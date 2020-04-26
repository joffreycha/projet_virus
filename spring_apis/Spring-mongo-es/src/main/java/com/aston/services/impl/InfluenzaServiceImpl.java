package com.aston.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aston.exceptions.NotFoundException;
import com.aston.models.mongo.InfluenzaMongo;
import com.aston.repositories.mongo.InfluenzaRepository;
import com.aston.services.InfluenzaService;

@Service
public class InfluenzaServiceImpl implements InfluenzaService {

	@Autowired InfluenzaRepository influenzaRepository;

	@Override
	public List<InfluenzaMongo> findAll() {
		return this.influenzaRepository.findAll();
	}

	@Override
	public InfluenzaMongo findById(String id) {
		Optional<InfluenzaMongo> inf  = this.influenzaRepository.findById(id);
		if (!inf.isPresent())
			throw new NotFoundException(id, InfluenzaMongo.class.getSimpleName());
		
		return inf.get();
	}

}
