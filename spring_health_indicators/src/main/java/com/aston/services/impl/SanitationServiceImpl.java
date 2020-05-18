package com.aston.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aston.exceptions.NotFoundException;
import com.aston.models.elastic.SanitationES;
import com.aston.models.elastic.UHCES;
import com.aston.models.mongo.Sanitation_hygiene;
import com.aston.models.mongo.Universal_health_coverage;
import com.aston.repositories.elastic.SanitationESRepository;
import com.aston.repositories.elastic.UHCESRepository;
import com.aston.repositories.mongo.SanitationMongoRepository;
import com.aston.repositories.mongo.UHCMongoRepository;
import com.aston.services.SanitationService;
import com.aston.services.UHCService;


@Service
public class SanitationServiceImpl implements SanitationService {

	@Autowired SanitationMongoRepository sanitationRepository;
	@Autowired SanitationESRepository sanitationESRepository;

	@Override
	public List<Sanitation_hygiene> findAll() {
		List<Sanitation_hygiene> liste = this.sanitationRepository.findAll();
		
		List<SanitationES> listeES = new ArrayList<>();
		int cpt = 1;
		for(Sanitation_hygiene i : liste)
		{
			
			SanitationES infES = new SanitationES(i);
			listeES.add(infES);
			cpt++;
			if(cpt==10000)
			{
				this.sanitationESRepository.saveAll(listeES);
				cpt=1;
				listeES = new ArrayList<>();
			}
		}
		this.sanitationESRepository.saveAll(listeES);
		return liste;
	}
	
	@Override
	public Sanitation_hygiene findById(String id) {
		Optional<Sanitation_hygiene> inf  = this.sanitationRepository.findById(id);
		if (!inf.isPresent())
			throw new NotFoundException(id, Sanitation_hygiene.class.getSimpleName());
		
		return inf.get();
	}
	

}
