package com.ford.interview.preassignment.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ford.interview.preassignment.model.Vehicles;
import com.ford.interview.preassignment.service.VehicleService;

@RestController
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	@RequestMapping(value = "/vehicleInfomation/submitVehicle", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> submitVehicle() throws FileNotFoundException, IOException {
		return vehicleService.upload();
	}

	@RequestMapping(value = "/getVehicleInfomation", method = RequestMethod.GET)
	@ResponseBody
	public List<Vehicles> getVehicleInformation() {
		return vehicleService.getVehicleInformation();
	}

	@RequestMapping(value = "/getVehicleModelName/{model}", method = RequestMethod.GET)
	@ResponseBody
	public List<Vehicles> getVehicleModelName(@PathVariable(name = "model") final String model) {
		return vehicleService.getVehicleModelName(model);
	}

	@RequestMapping(value = "/getVehiclePrice/{from}/{to}", method = RequestMethod.GET)
	@ResponseBody
	public List<Vehicles> getVehiclePrice(@PathVariable(name = "from") final String from,
			@PathVariable(name = "to") final String to) {
		return vehicleService.getVehiclePrice(from, to);
	}

	@RequestMapping(value = "/getVehicleByFeatures/{exterior}/{interior}", method = RequestMethod.GET)
	@ResponseBody
	public List<Vehicles> getVehicleFeatures(@PathVariable(name = "exterior") final String exterior,
			@PathVariable(name = "interior") final String interior) {
		return vehicleService.getVehicleFeatures(exterior, interior);
	}
}
