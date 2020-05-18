package com.aston.repositories.elastic;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import com.aston.models.elastic.MersES;

public interface MersESRepository extends ElasticsearchCrudRepository<MersES, String> {

}
