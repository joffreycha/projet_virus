package com.aston.repositories.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aston.models.mongo.Hospital_beds;



public interface HospitalBedsMongoRepository extends MongoRepository<Hospital_beds, String> {

}
