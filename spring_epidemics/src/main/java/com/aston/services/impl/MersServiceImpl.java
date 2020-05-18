package com.aston.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aston.exceptions.NotFoundException;
import com.aston.models.elastic.MersES;
import com.aston.models.mongo.Epidemics_mers;
import com.aston.repositories.elastic.MersESRepository;
import com.aston.repositories.mongo.MersMongoRepository;
import com.aston.services.MersService;


@Service
public class MersServiceImpl implements MersService {

	@Autowired MersMongoRepository mersRepository;
	@Autowired MersESRepository mersESRepository;

	@Override
	public List<Epidemics_mers> findAll() {
		List<Epidemics_mers> liste = this.mersRepository.findAll();
		
		List<MersES> listeES = new ArrayList<>();
		int cpt = 1;
		for(Epidemics_mers i : liste)
		{
			
			MersES infES = new MersES(i);
			listeES.add(infES);
			cpt++;
			if(cpt==10000)
			{
				this.mersESRepository.saveAll(listeES);
				cpt=1;
				listeES = new ArrayList<>();
			}
		}
		this.mersESRepository.saveAll(listeES);
		return liste;
	}
	
	@Override
	public Epidemics_mers findById(String id) {
		Optional<Epidemics_mers> inf  = this.mersRepository.findById(id);
		if (!inf.isPresent())
			throw new NotFoundException(id, Epidemics_mers.class.getSimpleName());
		
		return inf.get();
	}
	

}
