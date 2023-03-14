package com.ford.interview.preassignment.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ford.interview.preassignment.model.Vehicles;

public interface VehicleService {

	public ResponseEntity<String> upload() throws FileNotFoundException, IOException;

	public List<Vehicles> getVehicleInformation();

	public List<Vehicles> getVehicleModelName(final String model);

	public List<Vehicles> getVehiclePrice(final String from, final String to);

	public List<Vehicles> getVehicleFeatures(final String exterior, final String interior);
}
