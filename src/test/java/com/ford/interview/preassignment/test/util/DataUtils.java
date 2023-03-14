package com.ford.interview.preassignment.test.util;

import java.util.Arrays;
import java.util.List;

import org.springframework.util.ObjectUtils;

import com.ford.interview.preassignment.model.Vehicle;
import com.ford.interview.preassignment.model.VehicleDetails;
import com.ford.interview.preassignment.model.VehicleFeature;
import com.ford.interview.preassignment.model.VehiclePrice;
import com.ford.interview.preassignment.model.Vehicles;

public class DataUtils {

	public static List<Vehicles> getAllExpectedData() {
		{
			// vehicleID = 101
			final List<VehiclePrice> vehiclePrice101 = Arrays
					.asList(new VehiclePrice("$25,000.00", "$5000", "$20,000.00"));
			final VehicleFeature vehicleFeature101 = new VehicleFeature(
					Arrays.asList("Acoustic-Laminate Windshld", "Active Grille Shutters", "Windshield Wiper De-Icer",
							"Privacy Glass - Rear Doors"),
					Arrays.asList("Illuminated Entry System", "Powerpoints - 12V", "Power Driver Seat - 6-Way",
							"Unique Clth/Htd Frt Seats"));
			final VehicleDetails vehicleDetails101 = new VehicleDetails("Ford", "ecoSport", "2020", "4D Sport Utility",
					"1.0L EcoBoost", "FWD", "shadow black", "27", vehicleFeature101, vehiclePrice101);
			final Vehicle vehicle101 = new Vehicle("101", vehicleDetails101);

			// vehicleID = 102
			final List<VehiclePrice> vehiclePrice102 = Arrays
					.asList(new VehiclePrice("$30,000.00", "$2000", "$28,000.00"));
			final VehicleFeature vehicleFeature102 = new VehicleFeature(
					Arrays.asList("Beltline Molding - Black", "Door Handles - Body Color", "Grille - Chrome",
							"Taillamps-Led"),
					Arrays.asList("60/40 Split Fold Rear Seat", "Cruise Control", "Dual Illum Vis Vanity Mirr",
							"Rotary Gear Shift Dial"));
			final VehicleDetails vehicleDetails102 = new VehicleDetails("Ford", "Edge", "2019", "4D SuperCrew",
					"4D Sport Utility", "AWD", "Agate Black", "28", vehicleFeature102, vehiclePrice102);
			final Vehicle vehicle102 = new Vehicle("102", vehicleDetails102);

			// vehicleID = 103
			final List<VehiclePrice> vehiclePrice103 = Arrays
					.asList(new VehiclePrice("$40,925.00", "$4678.00", "$36,247.00"));
			final VehicleFeature vehicleFeature103 = new VehicleFeature(
					Arrays.asList("Headlamps - Autolamp", "Locking Removable Tailgate", "Manual Fold Power Mirrors",
							"Headlamps - Auto High Beam"),
					Arrays.asList("1Touch Up/Down Dr/Pass Win", "60/40 Fold-Up Rear Bench Seat", "Cruise Control",
							"Illuminated Entry"));
			final VehicleDetails vehicleDetails103 = new VehicleDetails("Ford", "F-150", "2020", "4D SuperCrew",
					"V6 PFDI", "4WD", "Blue Jeans Metallic", "23", vehicleFeature103, vehiclePrice103);
			final Vehicle vehicle103 = new Vehicle("103", vehicleDetails103);

			// vehicleID = 104
			final List<VehiclePrice> vehiclePrice104 = Arrays
					.asList(new VehiclePrice("$33,645.70", "$4,988.20", "$28657.50"));
			final VehicleFeature vehicleFeature104 = new VehicleFeature(
					Arrays.asList("Dual Exhaust System", "Easy Fuel Capless Filler", "Headlamps - Autolamp",
							"Headlamps- Led With Signature Lighting"),
					Arrays.asList("Autodim Rearview Mirror", "Center Console W/Armrest", "Floor Mats - Front",
							"Smart Charging Usb Port(2)"));
			final VehicleDetails vehicleDetails104 = new VehicleDetails("Ford", "mustang", "2017", "4D Sport Utility",
					"V8", "RWD", "Blue Metallic", "32", vehicleFeature104, vehiclePrice104);
			final Vehicle vehicle104 = new Vehicle("104", vehicleDetails104);

			// vehicleID = 105
			final List<VehiclePrice> vehiclePrice105 = Arrays
					.asList(new VehiclePrice("$35,515.00", "$5000", "$30,515.00"));
			final VehicleFeature vehicleFeature105 = new VehicleFeature(
					Arrays.asList("Daytime Running Lights", "Easy Fuel Capless Filler", "Fuel Tank - 18.0 Gallon",
							"Tow Hooks"),
					Arrays.asList("110V Outlet", "Dual Sliding Sunvisors", "Dual Zone Auto Climate Ctl",
							"Overhead Console"));
			final VehicleDetails vehicleDetails105 = new VehicleDetails("Ford", "Ranger", "2016", "Super Cab",
					"2.3L EcoBoost", "4WD", "Oxford White", "24", vehicleFeature105, vehiclePrice105);
			final Vehicle vehicle105 = new Vehicle("105", vehicleDetails105);

			final List<Vehicle> vehicleList = Arrays.asList(vehicle101, vehicle102, vehicle103, vehicle104, vehicle105);
			final Vehicles vehicles = new Vehicles(vehicleList);
			final List<Vehicles> expectedVehiclesList = Arrays.asList(vehicles);

			return expectedVehiclesList;
		}
	}

	public static List<Vehicles> getVehicleModelNameData() {
		{
			final List<Vehicles> allExpectedData = getAllExpectedData();
			if (ObjectUtils.isEmpty(Arrays.asList(allExpectedData.get(1)))) {
				return null;
			}
			return Arrays.asList(allExpectedData.get(1));
		}
	}

	public static List<Vehicles> getVehiclePriceData() {
		{
			final List<Vehicles> allExpectedData = getAllExpectedData();
			if (ObjectUtils
					.isEmpty(Arrays.asList(allExpectedData.get(1), allExpectedData.get(3), allExpectedData.get(4)))) {
				return null;
			}
			return Arrays.asList(allExpectedData.get(1), allExpectedData.get(3), allExpectedData.get(4));
		}
	}

	public static List<Vehicles> getVehicleFeaturesData() {
		{
			final List<Vehicles> allExpectedData = getAllExpectedData();
			if (ObjectUtils.isEmpty(Arrays.asList(allExpectedData.get(4)))) {
				return null;
			}
			return Arrays.asList(allExpectedData.get(4));
		}
	}
}
