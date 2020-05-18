package com.aston.repositories.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aston.models.mongo.Sanitation_hygiene;


public interface SanitationMongoRepository extends MongoRepository<Sanitation_hygiene, String> {

}
