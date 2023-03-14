package com.ford.interview.preassignment.config;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoConfig {
	@Primary
	@Bean(name = "vehicleStoreProperties")
	@ConfigurationProperties(prefix = "spring.data.mongodb.vehiclestore")
	public MongoProperties getVehicleStoreProps() throws Exception {
		return new MongoProperties();
	}

	@Primary
	@Bean(name = "vehicleStoreMongoTemplate")
	public MongoTemplate vehicleStoreMongoTemplate() throws Exception {
		return new MongoTemplate(vehicleStoreMongoDatabaseFactory(getVehicleStoreProps()));
	}

	@Primary
	@Bean
	public MongoDatabaseFactory vehicleStoreMongoDatabaseFactory(MongoProperties mongo) throws Exception {
		return new SimpleMongoClientDatabaseFactory(mongo.getUri());
	}
}