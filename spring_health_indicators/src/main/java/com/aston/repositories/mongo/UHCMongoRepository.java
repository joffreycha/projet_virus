package com.aston.repositories.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aston.models.mongo.Universal_health_coverage;


public interface UHCMongoRepository extends MongoRepository<Universal_health_coverage, String> {

}
