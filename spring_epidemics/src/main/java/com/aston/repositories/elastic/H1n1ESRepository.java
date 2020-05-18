package com.aston.repositories.elastic;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import com.aston.models.elastic.H1n1ES;

public interface H1n1ESRepository extends ElasticsearchCrudRepository<H1n1ES, String> {

}
