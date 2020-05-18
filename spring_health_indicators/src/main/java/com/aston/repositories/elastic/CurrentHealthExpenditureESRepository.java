package com.aston.repositories.elastic;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import com.aston.models.elastic.CurrentHealthExpenditureES;

public interface CurrentHealthExpenditureESRepository extends ElasticsearchCrudRepository<CurrentHealthExpenditureES, String> {

}
