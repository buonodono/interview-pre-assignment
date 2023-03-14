package com.ford.interview.preassignment.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({ "make", "model", "modelYear", "bodyStyle", "engine", "drivetype", "color", "mpg", "vehicleFeature",
		"vehiclePrice" })
public class VehicleDetails {

	@Setter
	@Field("make")
	private String make;
	@Setter
	@Field("model")
	private String model;
	@Setter
	@Field("modelYear")
	private String modelYear;
	@Setter
	@Field("bodyStyle")
	private String bodyStyle;
	@Setter
	@Field("engine")
	private String engine;
	@Setter
	@Field("drivetype")
	private String drivetype;
	@Setter
	@Field("color")
	private String color;
	@Setter
	@Field("MPG")
	@JsonProperty("MPG")
	private String mpg;
	@Setter
	private VehicleFeature vehicleFeature;
	@Field("vehiclePrice")
	@Setter
	private List<VehiclePrice> vehiclePrice;
}
