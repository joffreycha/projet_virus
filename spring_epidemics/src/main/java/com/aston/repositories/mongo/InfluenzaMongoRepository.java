package com.aston.repositories.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aston.models.mongo.Epidemics_influenza;


public interface InfluenzaMongoRepository extends MongoRepository<Epidemics_influenza, String> {

}
