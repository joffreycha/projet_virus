package com.aston.repositories.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aston.models.mongo.Epidemics_mers;



public interface MersMongoRepository extends MongoRepository<Epidemics_mers, String> {

}
