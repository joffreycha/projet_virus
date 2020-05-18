package com.aston.repositories.elastic;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import com.aston.models.elastic.CurrentHealthExpenditureES;
import com.aston.models.elastic.SanitationES;

public interface SanitationESRepository extends ElasticsearchCrudRepository<SanitationES, String> {

}
