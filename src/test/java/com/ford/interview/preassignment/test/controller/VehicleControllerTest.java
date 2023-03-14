package com.ford.interview.preassignment.test.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;

import com.ford.interview.preassignment.controller.VehicleController;
import com.ford.interview.preassignment.model.Vehicles;
import com.ford.interview.preassignment.service.VehicleService;
import com.ford.interview.preassignment.test.util.DataUtils;

@ExtendWith(MockitoExtension.class)
public class VehicleControllerTest {
	@InjectMocks
	private VehicleController vehicleController;

	@Mock
	private VehicleService vehicleServiceMock;

	@Test
	public void submitVehicle() throws FileNotFoundException, IOException {
		{
			final String success = "Successfully inserted document - id: 1234";
			Mockito.when(vehicleServiceMock.upload()).thenReturn(new ResponseEntity<>(success, HttpStatus.OK));
			final ResponseEntity<String> response = vehicleController.submitVehicle();
			assertFalse(ObjectUtils.isEmpty(response));
			assertEquals(HttpStatus.OK, response.getStatusCode());
			assertEquals(success, response.getBody());
		}

	}

	@Test
	public void getVehicleInformation() {
		{
			Mockito.when(vehicleServiceMock.getVehicleInformation()).thenReturn(DataUtils.getAllExpectedData());
			final List<Vehicles> actualVehiclesList = vehicleController.getVehicleInformation();
			assertFalse(ObjectUtils.isEmpty(actualVehiclesList));
			assertEquals(DataUtils.getAllExpectedData(), actualVehiclesList);
		}
	}

	@Disabled
	public void getVehicleModelName() {
		{
			final String model = "Edge";
			Mockito.when(vehicleServiceMock.getVehicleModelName(model)).thenReturn(DataUtils.getVehicleModelNameData());
			final List<Vehicles> actualVehiclesList = vehicleController.getVehicleModelName(model);
			assertFalse(ObjectUtils.isEmpty(actualVehiclesList));
			assertEquals(DataUtils.getVehicleModelNameData(), actualVehiclesList);
		}
	}

	@Disabled
	public void getVehiclePrice() {
		{
			final String from = "25,000.00";
			final String to = "35,000.00";
			final List<Vehicles> actualVehiclesList = vehicleController.getVehiclePrice(from, to);
			Mockito.when(vehicleServiceMock.getVehiclePrice(from, to)).thenReturn(DataUtils.getVehiclePriceData());
			assertFalse(ObjectUtils.isEmpty(actualVehiclesList));
			assertEquals(DataUtils.getVehiclePriceData(), actualVehiclesList);
		}
	}

	@Disabled
	public void getVehicleFeatures() {
		{
			final String exterior = "Lights";
			final String interior = "Sunvisors";
			final List<Vehicles> actualVehiclesList = vehicleController.getVehicleFeatures(exterior, interior);
			Mockito.when(vehicleServiceMock.getVehicleFeatures(exterior, interior))
					.thenReturn(DataUtils.getVehicleFeaturesData());
			assertFalse(ObjectUtils.isEmpty(actualVehiclesList));
			assertEquals(DataUtils.getVehiclePriceData(), actualVehiclesList);
		}
	}
}
