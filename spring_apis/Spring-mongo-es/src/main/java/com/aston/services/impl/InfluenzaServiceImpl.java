package com.aston.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aston.exceptions.NotFoundException;
import com.aston.models.elastic.InfluenzaES;
import com.aston.models.mongo.Influenza;
import com.aston.repositories.elastic.InfluenzaESRepository;
import com.aston.repositories.mongo.InfluenzaMongoRepository;
import com.aston.services.InfluenzaService;

@Service
public class InfluenzaServiceImpl implements InfluenzaService {

	@Autowired InfluenzaMongoRepository influenzaRepository;
	@Autowired InfluenzaESRepository influenzaESRepository;

	@Override
	public List<Influenza> findAll() {
		return this.influenzaRepository.findAll();
	}

	@Override
	public InfluenzaES save(Influenza inf) {
		// Enregistre le doc avec les champs utiles à ElasticSearch
		InfluenzaES infES = new InfluenzaES(inf);
		return this.influenzaESRepository.save(infES);
	}
	
	@Override
	public Influenza findById(String id) {
		Optional<Influenza> inf  = this.influenzaRepository.findById(id);
		if (!inf.isPresent())
			throw new NotFoundException(id, Influenza.class.getSimpleName());
		
		return inf.get();
	}

}
