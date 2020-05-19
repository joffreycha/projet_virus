package com.aston.repositories.elastic;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import com.aston.models.elastic.SarsES;

public interface SarsESRepository extends ElasticsearchCrudRepository<SarsES, String> {

}
