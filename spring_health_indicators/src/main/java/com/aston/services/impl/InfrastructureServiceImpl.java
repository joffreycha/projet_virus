package com.aston.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aston.exceptions.NotFoundException;
import com.aston.models.elastic.InfrastructureES;
import com.aston.models.mongo.Infrastructure;
import com.aston.models.mongo.Universal_health_coverage;
import com.aston.repositories.elastic.InfrastructureESRepository;
import com.aston.repositories.mongo.InfrastructureMongoRepository;
import com.aston.services.InfrastructureService;


@Service
public class InfrastructureServiceImpl implements InfrastructureService {

	@Autowired InfrastructureMongoRepository infrastructureRepository;
	@Autowired InfrastructureESRepository infrastructureESRepository;

	@Override
	public List<Infrastructure> findAll() {
		List<Infrastructure> liste = this.infrastructureRepository.findAll();
		
		List<InfrastructureES> listeES = new ArrayList<>();
		int cpt = 1;
		for(Infrastructure i : liste)
		{
			
			InfrastructureES infES = new InfrastructureES(i);
			listeES.add(infES);
			cpt++;
			if(cpt==10000)
			{
				this.infrastructureESRepository.saveAll(listeES);
				cpt=1;
				listeES = new ArrayList<>();
			}
		}
		this.infrastructureESRepository.saveAll(listeES);
		return liste;
	}
	
	@Override
	public Infrastructure findById(String id) {
		Optional<Infrastructure> inf  = this.infrastructureRepository.findById(id);
		if (!inf.isPresent())
			throw new NotFoundException(id, Infrastructure.class.getSimpleName());
		
		return inf.get();
	}
	

}
