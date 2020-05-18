package com.aston.repositories.elastic;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import com.aston.models.elastic.InfrastructureES;

public interface InfrastructureESRepository extends ElasticsearchCrudRepository<InfrastructureES, String> {

}
