
package com.ford.interview.preassignment.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Document(collection = "vehicleCollection")
public class Vehicles {

	@Id
	@Field("_id")
	@JsonIgnore
	private String id;
	@JsonInclude(Include.NON_NULL)
	private Vehicles vehicles;
	@Setter
	@JsonInclude(Include.NON_NULL)
	public List<Vehicle> vehicle;

	public Vehicles(List<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
}
