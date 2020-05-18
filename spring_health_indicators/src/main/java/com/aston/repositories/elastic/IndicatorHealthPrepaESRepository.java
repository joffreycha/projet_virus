package com.aston.repositories.elastic;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;


import com.aston.models.elastic.IndicatorHealthPrepaES;

public interface IndicatorHealthPrepaESRepository extends ElasticsearchCrudRepository<IndicatorHealthPrepaES, String> {

}
