package com.aston.repositories.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aston.models.mongo.Sanitation;


public interface SanitationMongoRepository extends MongoRepository<Sanitation, String> {

}
