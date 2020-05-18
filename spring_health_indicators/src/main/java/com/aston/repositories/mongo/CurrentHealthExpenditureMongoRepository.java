package com.aston.repositories.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aston.models.mongo.CurrentHealthExpenditure;


public interface CurrentHealthExpenditureMongoRepository extends MongoRepository<CurrentHealthExpenditure, String> {

}
