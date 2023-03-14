package com.ford.interview.preassignment.model;

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
@JsonPropertyOrder({ "msrp", "savings", "finalPrice" })
public class VehiclePrice {

	@Setter
	@Field("MSRP")
	@JsonProperty("MSRP")
	private String msrp;
	@Setter
	@Field("Savings")
	@JsonProperty("Savings")
	private String savings;
	@Setter
	@Field("finalPrice")
	private String finalPrice;
}
