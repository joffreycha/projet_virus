package com.aston.repositories.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aston.models.mongo.Influenza;

public interface InfluenzaMongoRepository extends MongoRepository<Influenza, String> {

}
