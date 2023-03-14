package com.ford.interview.preassignment.exception;

public class VehicleSearchParameterException extends RuntimeException {

	private static final long serialVersionUID = 2L;
	public static final String INVALID_SEARCH_PARAMETER = "Search parameter must be at least three characters: ";
	public static final String INVALID_SEARCH_PARAMETERS = "Search parameters must be at least three characters: ";
	public static final String SEPARATOR = " | ";

	public VehicleSearchParameterException(String message) {
		super(message);
	}
}