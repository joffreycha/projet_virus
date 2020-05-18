package com.aston.repositories.elastic;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import com.aston.models.elastic.CurrentHealthExpenditureES;
import com.aston.models.elastic.WorkforceES;

public interface WorkforceESRepository extends ElasticsearchCrudRepository<WorkforceES, String> {

}
