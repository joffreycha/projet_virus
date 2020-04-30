package com.aston.services.impl;

import java.util.ArrayList;
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
		List<Influenza> liste = this.influenzaRepository.findAll();
		
		List<InfluenzaES> listeES = new ArrayList<>();
		int cpt = 1;
		for(Influenza i : liste)
		{
			
			InfluenzaES infES = new InfluenzaES(i);
			listeES.add(infES);
			cpt++;
			if(cpt==10000)
			{
				this.influenzaESRepository.saveAll(listeES);
				cpt=1;
				listeES = new ArrayList<>();
			}
		}
		this.influenzaESRepository.saveAll(listeES);
		return liste;
	}
	
	@Override
	public Influenza findById(String id) {
		Optional<Influenza> inf  = this.influenzaRepository.findById(id);
		if (!inf.isPresent())
			throw new NotFoundException(id, Influenza.class.getSimpleName());
		
		return inf.get();
	}
	

}
