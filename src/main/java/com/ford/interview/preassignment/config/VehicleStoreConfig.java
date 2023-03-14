package com.ford.interview.preassignment.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {
		"com.ford.interview.preassignment.repository.vehicleRepositroy" }, mongoTemplateRef = VehicleStoreConfig.MONGO_TEMPLATE)
public class VehicleStoreConfig {
	protected static final String MONGO_TEMPLATE = "vehicleStoreMongoTemplate";
}