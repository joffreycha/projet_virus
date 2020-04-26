package com.aston.services;

import java.util.List;

import com.aston.models.mongo.InfluenzaMongo;

public interface InfluenzaService {

	public List<InfluenzaMongo> findAll();
	public InfluenzaMongo findById(String id);
}
