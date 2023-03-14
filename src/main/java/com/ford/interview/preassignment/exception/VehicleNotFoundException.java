package com.ford.interview.preassignment.exception;

public class VehicleNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public static final String NO_VEHICLES_FOUND = "No vehicles found.";
	public static final String NO_VEHICLE_FOUND = "No vehicle found with the parameter(s): ";

	public VehicleNotFoundException(String message) {
		super(message);
	}
}