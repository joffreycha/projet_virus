package com.aston.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aston.exceptions.NotFoundException;
import com.aston.models.elastic.CurrentHealthExpenditureES;
import com.aston.models.elastic.InfrastructureES;
import com.aston.models.elastic.UHCES;
import com.aston.models.mongo.Current_health_expenditure;
import com.aston.models.mongo.Infrastructure;
import com.aston.models.mongo.Universal_health_coverage;
import com.aston.repositories.elastic.CurrentHealthExpenditureESRepository;
import com.aston.repositories.elastic.InfrastructureESRepository;
import com.aston.repositories.elastic.UHCESRepository;
import com.aston.repositories.mongo.CurrentHealthExpenditureMongoRepository;
import com.aston.repositories.mongo.InfrastructureMongoRepository;
import com.aston.repositories.mongo.UHCMongoRepository;
import com.aston.services.CurrentHealthExpenditureService;
import com.aston.services.InfrastructureService;
import com.aston.services.UHCService;


@Service
public class CurrentHealthExpenditureServiceImpl implements CurrentHealthExpenditureService{
	@Autowired CurrentHealthExpenditureMongoRepository currentHealthExpenditureRepository;
	@Autowired CurrentHealthExpenditureESRepository currentHealthExpenditureESRepository;

	@Override
	public List<Current_health_expenditure> findAll() {
		List<Current_health_expenditure> liste = this.currentHealthExpenditureRepository.findAll();
		
		List<CurrentHealthExpenditureES> listeES = new ArrayList<>();
		int cpt = 1;
		for(Current_health_expenditure i : liste)
		{
			
			CurrentHealthExpenditureES infES = new CurrentHealthExpenditureES(i);
			listeES.add(infES);
			cpt++;
			if(cpt==10000)
			{
				this.currentHealthExpenditureESRepository.saveAll(listeES);
				cpt=1;
				listeES = new ArrayList<>();
			}
		}
		this.currentHealthExpenditureESRepository.saveAll(listeES);
		return liste;
	}
	
	@Override
	public Current_health_expenditure findById(String id) {
		Optional<Current_health_expenditure> inf  = this.currentHealthExpenditureRepository.findById(id);
		if (!inf.isPresent())
			throw new NotFoundException(id, Current_health_expenditure.class.getSimpleName());
		
		return inf.get();
	}
	

}
