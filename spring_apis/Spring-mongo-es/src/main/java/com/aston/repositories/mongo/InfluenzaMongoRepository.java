package com.aston.repositories.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aston.models.mongo.InfluenzaMongo;

public interface InfluenzaMongoRepository extends MongoRepository<InfluenzaMongo, String> {

}
