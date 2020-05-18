package com.aston.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aston.exceptions.NotFoundException;
import com.aston.models.elastic.InfluenzaES;
import com.aston.models.mongo.Epidemics_influenza;
import com.aston.repositories.elastic.InfluenzaESRepository;
import com.aston.repositories.mongo.InfluenzaMongoRepository;
import com.aston.services.InfluenzaService;


@Service
public class InfluenzaServiceImpl implements InfluenzaService {

	@Autowired InfluenzaMongoRepository influenzaRepository;
	@Autowired InfluenzaESRepository influenzaESRepository;

	@Override
	public List<Epidemics_influenza> findAll() {
		List<Epidemics_influenza> liste = this.influenzaRepository.findAll();
		
		List<InfluenzaES> listeES = new ArrayList<>();
		int cpt = 1;
		for(Epidemics_influenza i : liste)
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
	public Epidemics_influenza findById(String id) {
		Optional<Epidemics_influenza> inf  = this.influenzaRepository.findById(id);
		if (!inf.isPresent())
			throw new NotFoundException(id, Epidemics_influenza.class.getSimpleName());
		
		return inf.get();
	}
	

}
