package com.aston.repositories.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aston.models.mongo.Infrastructure;



public interface InfrastructureMongoRepository extends MongoRepository<Infrastructure, String> {

}
