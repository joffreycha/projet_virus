package com.aston.repositories.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aston.models.mongo.Current_health_expenditure;


public interface CurrentHealthExpenditureMongoRepository extends MongoRepository<Current_health_expenditure, String> {

}
