package com.aston.repositories.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aston.models.mongo.HospitalBeds;



public interface HospitalBedsMongoRepository extends MongoRepository<HospitalBeds, String> {

}
