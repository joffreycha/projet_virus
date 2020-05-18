package com.aston.repositories.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aston.models.mongo.Universal_health_coverage;
import com.aston.models.mongo.Workforce;


public interface WorkforceMongoRepository extends MongoRepository<Workforce, String> {

}
