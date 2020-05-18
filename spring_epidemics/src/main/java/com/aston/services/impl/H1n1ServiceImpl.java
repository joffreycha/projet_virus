package com.aston.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aston.exceptions.NotFoundException;
import com.aston.models.elastic.H1n1ES;
import com.aston.models.mongo.Epidemics_h1n1;
import com.aston.repositories.elastic.H1n1ESRepository;
import com.aston.repositories.mongo.H1n1MongoRepository;
import com.aston.services.H1n1Service;


@Service
public class H1n1ServiceImpl implements H1n1Service {

	@Autowired H1n1MongoRepository h1n1Repository;
	@Autowired H1n1ESRepository h1n1ESRepository;

	@Override
	public List<Epidemics_h1n1> findAll() {
		List<Epidemics_h1n1> liste = this.h1n1Repository.findAll();
		
		List<H1n1ES> listeES = new ArrayList<>();
		int cpt = 1;
		for(Epidemics_h1n1 i : liste)
		{
			
			H1n1ES infES = new H1n1ES(i);
			listeES.add(infES);
			cpt++;
			if(cpt==10000)
			{
				this.h1n1ESRepository.saveAll(listeES);
				cpt=1;
				listeES = new ArrayList<>();
			}
		}
		this.h1n1ESRepository.saveAll(listeES);
		return liste;
	}
	
	@Override
	public Epidemics_h1n1 findById(String id) {
		Optional<Epidemics_h1n1> inf  = this.h1n1Repository.findById(id);
		if (!inf.isPresent())
			throw new NotFoundException(id, Epidemics_h1n1.class.getSimpleName());
		
		return inf.get();
	}
	

}
