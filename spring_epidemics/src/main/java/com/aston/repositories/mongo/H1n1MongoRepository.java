package com.aston.repositories.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aston.models.mongo.Epidemics_h1n1;

public interface H1n1MongoRepository extends MongoRepository<Epidemics_h1n1, String> {

}
