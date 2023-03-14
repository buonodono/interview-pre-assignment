package com.ford.interview.preassignment.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ford.interview.preassignment.model.Vehicles;

public interface VehicleStoreRepository extends MongoRepository<Vehicles, String> {
}
