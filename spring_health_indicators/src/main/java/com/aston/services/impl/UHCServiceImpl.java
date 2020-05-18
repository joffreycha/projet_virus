package com.aston.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aston.exceptions.NotFoundException;
import com.aston.models.elastic.UHCES;
import com.aston.models.mongo.Universal_health_coverage;
import com.aston.repositories.elastic.UHCESRepository;
import com.aston.repositories.mongo.UHCMongoRepository;
import com.aston.services.UHCService;


@Service
public class UHCServiceImpl implements UHCService {

	@Autowired UHCMongoRepository uhcRepository;
	@Autowired UHCESRepository uhcESRepository;

	@Override
	public List<Universal_health_coverage> findAll() {
		List<Universal_health_coverage> liste = this.uhcRepository.findAll();
		
		List<UHCES> listeES = new ArrayList<>();
		int cpt = 1;
		for(Universal_health_coverage i : liste)
		{
			
			UHCES infES = new UHCES(i);
			listeES.add(infES);
			cpt++;
			if(cpt==10000)
			{
				this.uhcESRepository.saveAll(listeES);
				cpt=1;
				listeES = new ArrayList<>();
			}
		}
		this.uhcESRepository.saveAll(listeES);
		return liste;
	}
	
	@Override
	public Universal_health_coverage findById(String id) {
		Optional<Universal_health_coverage> inf  = this.uhcRepository.findById(id);
		if (!inf.isPresent())
			throw new NotFoundException(id, Universal_health_coverage.class.getSimpleName());
		
		return inf.get();
	}
	

}
