package com.aston.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aston.exceptions.NotFoundException;
import com.aston.models.elastic.InfrastructureES;
import com.aston.models.elastic.UHCES;
import com.aston.models.elastic.WorkforceES;
import com.aston.models.mongo.Infrastructure;
import com.aston.models.mongo.Universal_health_coverage;
import com.aston.models.mongo.Workforce;
import com.aston.repositories.elastic.InfrastructureESRepository;
import com.aston.repositories.elastic.UHCESRepository;
import com.aston.repositories.elastic.WorkforceESRepository;
import com.aston.repositories.mongo.InfrastructureMongoRepository;
import com.aston.repositories.mongo.UHCMongoRepository;
import com.aston.repositories.mongo.WorkforceMongoRepository;
import com.aston.services.InfrastructureService;
import com.aston.services.UHCService;
import com.aston.services.WorkforceService;


@Service
public class WorkforceServiceImpl implements WorkforceService {

	@Autowired WorkforceMongoRepository workforceRepository;
	@Autowired WorkforceESRepository workforceESRepository;

	@Override
	public List<Workforce> findAll() {
		List<Workforce> liste = this.workforceRepository.findAll();
		
		List<WorkforceES> listeES = new ArrayList<>();
		int cpt = 1;
		for(Workforce i : liste)
		{
			
			WorkforceES infES = new WorkforceES(i);
			listeES.add(infES);
			cpt++;
			if(cpt==10000)
			{
				this.workforceESRepository.saveAll(listeES);
				cpt=1;
				listeES = new ArrayList<>();
			}
		}
		this.workforceESRepository.saveAll(listeES);
		return liste;
	}
	
	@Override
	public Workforce findById(String id) {
		Optional<Workforce> inf  = this.workforceRepository.findById(id);
		if (!inf.isPresent())
			throw new NotFoundException(id, Workforce.class.getSimpleName());
		
		return inf.get();
	}
	

}
