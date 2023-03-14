package com.ford.interview.preassignment.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleFeature {

	@Setter
	@Field("Exterior")
	@JsonProperty("Exterior")
	public List<String> exterior;
	@Setter
	@Field("Interior")
	@JsonProperty("Interior")
	public List<String> interior;
}
