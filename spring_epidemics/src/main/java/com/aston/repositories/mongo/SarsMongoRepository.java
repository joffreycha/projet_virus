package com.aston.repositories.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aston.models.mongo.Epidemics_sars;


public interface SarsMongoRepository extends MongoRepository<Epidemics_sars, String> {

}
