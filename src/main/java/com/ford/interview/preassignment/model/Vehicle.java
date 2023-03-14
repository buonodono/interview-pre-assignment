package com.ford.interview.preassignment.model;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

	@Setter
	@Field("vehicleId")
	private String vehicleId;
	@Setter
	@Field("vehicleDetails")
	private VehicleDetails vehicleDetails;
}
