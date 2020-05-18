package com.aston.repositories.elastic;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import com.aston.models.elastic.HospitalBedsES;

public interface HospitalBedsESRepository extends ElasticsearchCrudRepository<HospitalBedsES, String> {

}
