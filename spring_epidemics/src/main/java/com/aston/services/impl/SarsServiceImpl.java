package com.aston.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aston.exceptions.NotFoundException;
import com.aston.models.elastic.SarsES;
import com.aston.models.mongo.Epidemics_sars;
import com.aston.repositories.elastic.SarsESRepository;
import com.aston.repositories.mongo.SarsMongoRepository;
import com.aston.services.SarsService;


@Service
public class SarsServiceImpl implements SarsService{
	@Autowired SarsMongoRepository sarsRepository;
	@Autowired SarsESRepository sarsESRepository;

	@Override
	public List<Epidemics_sars> findAll() {
		List<Epidemics_sars> liste = this.sarsRepository.findAll();
		
		List<SarsES> listeES = new ArrayList<>();
		int cpt = 1;
		for(Epidemics_sars i : liste)
		{
			
			SarsES infES = new SarsES(i);
			listeES.add(infES);
			cpt++;
			if(cpt==10000)
			{
				this.sarsESRepository.saveAll(listeES);
				cpt=1;
				listeES = new ArrayList<>();
			}
		}
		this.sarsESRepository.saveAll(listeES);
		return liste;
	}
	
	@Override
	public Epidemics_sars findById(String id) {
		Optional<Epidemics_sars> inf  = this.sarsRepository.findById(id);
		if (!inf.isPresent())
			throw new NotFoundException(id, Epidemics_sars.class.getSimpleName());
		
		return inf.get();
	}
	

}
