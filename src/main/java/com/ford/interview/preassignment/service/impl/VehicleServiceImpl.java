package com.ford.interview.preassignment.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.bson.Document;
import org.bson.json.JsonParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.ford.interview.preassignment.exception.VehicleNotFoundException;
import com.ford.interview.preassignment.exception.VehicleSearchParameterException;
import com.ford.interview.preassignment.model.Vehicles;
import com.ford.interview.preassignment.service.VehicleService;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;

@Service("VehicleService")
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private MongoTemplate vehicleStoreMongoTemplate;

	final private int acceptedParamLength = 3;
	final private String documentError = "Unable to insert document because of an error: ";
	final private String documentSuccess = "Successfully inserted document - id: ";
	final private String filePath = "src/main/resources/static/vehicles.json";

	public ResponseEntity<String> upload() throws FileNotFoundException, IOException {
		final String jsonString = FileUtils.readFileToString(new File(filePath), "UTF-8");
		Document document = new Document();
		try {
			document = Document.parse(jsonString);
		} catch (JsonParseException jsonParseException) {
			jsonParseException.printStackTrace();
		}

		InsertOneResult result = null;
		try {
			final MongoCollection<Document> collection = vehicleStoreMongoTemplate.getCollection("vehicleCollection");
			result = collection.insertOne(document);
		} catch (MongoException mongoException) {
			return new ResponseEntity<>(documentError + mongoException + mongoException.getCode(),
					HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(documentSuccess + result.getInsertedId().toString(), HttpStatus.OK);
	}

	public List<Vehicles> getVehicleInformation() {
		final List<Vehicles> vehicleList = vehicleStoreMongoTemplate.findAll(Vehicles.class);

		if (ObjectUtils.isEmpty(vehicleList)) {
			throw new VehicleNotFoundException(VehicleNotFoundException.NO_VEHICLES_FOUND);
		}
		return vehicleList;
	}

	public List<Vehicles> getVehicleModelName(final String model) {
		final Criteria elementMatchCriteria = Criteria.where("vehicles.vehicle.vehicleDetails").exists(true)
				.elemMatch(Criteria.where("model").is(model));
		final Query query = new Query(elementMatchCriteria);
		final List<Vehicles> vehicle = vehicleStoreMongoTemplate.find(query, Vehicles.class);

		if (ObjectUtils.isEmpty(vehicle)) {
			throw new VehicleNotFoundException(VehicleNotFoundException.NO_VEHICLE_FOUND + model);
		}
		return vehicle;
	}

	public List<Vehicles> getVehiclePrice(final String from, final String to) {
		final String removeCurrencyCharacters = "[$,]";
		final double doubleFrom = Double.parseDouble(from.replaceAll(removeCurrencyCharacters, ""));
		final double doubleTo = Double.parseDouble(to.replaceAll(removeCurrencyCharacters, ""));

		final Criteria elementMatchCriteria = Criteria.where("vehicles.vehicle.vehicleDetails").exists(true)
				.elemMatch(Criteria.where("finalPrice").gt(doubleFrom).lt(doubleTo));
		final Query query = new Query(elementMatchCriteria);
		final List<Vehicles> vehicles = vehicleStoreMongoTemplate.find(query, Vehicles.class);

		if (ObjectUtils.isEmpty(vehicles)) {
			throw new VehicleNotFoundException(
					VehicleNotFoundException.NO_VEHICLE_FOUND + from + VehicleSearchParameterException.SEPARATOR + to);
		}
		return vehicles;
	}

	public List<Vehicles> getVehicleFeatures(final String exterior, final String interior) {
		if (acceptedParamLength > exterior.length() && acceptedParamLength > interior.length()) {
			throw new VehicleSearchParameterException(VehicleSearchParameterException.INVALID_SEARCH_PARAMETER
					+ exterior + VehicleSearchParameterException.SEPARATOR + interior);
		}
		if (acceptedParamLength > exterior.length()) {
			throw new VehicleSearchParameterException(
					VehicleSearchParameterException.INVALID_SEARCH_PARAMETER + exterior);
		}
		if (acceptedParamLength > interior.length()) {
			throw new VehicleSearchParameterException(
					VehicleSearchParameterException.INVALID_SEARCH_PARAMETER + interior);
		}

		final Criteria elementMatchCriteria = Criteria.where("vehicles.vehicle.vehicleDetails").exists(true).elemMatch(
				Criteria.where("exterior").regex(".*" + exterior + ".*").and("interior").regex(".*" + interior + ".*"));
		final Query query = new Query(elementMatchCriteria);
		final List<Vehicles> vehicles = vehicleStoreMongoTemplate.find(query, Vehicles.class);

		if (ObjectUtils.isEmpty(vehicles)) {
			throw new VehicleNotFoundException(VehicleNotFoundException.NO_VEHICLE_FOUND + exterior
					+ VehicleSearchParameterException.SEPARATOR + interior);
		}
		return vehicles;
	}
}
