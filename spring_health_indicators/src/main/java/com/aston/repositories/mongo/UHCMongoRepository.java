package com.aston.repositories.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aston.models.mongo.UHC;


public interface UHCMongoRepository extends MongoRepository<UHC, String> {

}
