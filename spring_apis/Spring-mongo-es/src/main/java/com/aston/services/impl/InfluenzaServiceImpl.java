package com.aston.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aston.exceptions.NotFoundException;
import com.aston.models.elastic.InfluenzaES;
import com.aston.models.mongo.InfluenzaMongo;
import com.aston.repositories.elastic.InfluenzaESRepository;
import com.aston.repositories.mongo.InfluenzaMongoRepository;
import com.aston.services.InfluenzaService;

@Service
public class InfluenzaServiceImpl implements InfluenzaService {

	@Autowired InfluenzaMongoRepository influenzaRepository;
	@Autowired InfluenzaESRepository influenzaESRepository;

	@Override
	public List<InfluenzaMongo> findAll() {
		return this.influenzaRepository.findAll();
	}

	@Override
	public InfluenzaES save(InfluenzaMongo inf) {
		// Enregistre le doc avec les champs utiles à ElasticSearch
		InfluenzaES infES = new InfluenzaES(inf);
		return this.influenzaESRepository.save(infES);
	}
	
	@Override
	public InfluenzaMongo findById(String id) {
		Optional<InfluenzaMongo> inf  = this.influenzaRepository.findById(id);
		if (!inf.isPresent())
			throw new NotFoundException(id, InfluenzaMongo.class.getSimpleName());
		
		return inf.get();
	}

}
