package com.aston.repositories.elastic;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import com.aston.models.elastic.InfluenzaES;

public interface InfluenzaESRepository extends ElasticsearchCrudRepository<InfluenzaES, String> {

}
