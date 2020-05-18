package com.aston.repositories.elastic;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;


import com.aston.models.elastic.UHCES;

public interface UHCESRepository extends ElasticsearchCrudRepository<UHCES, String> {

}
