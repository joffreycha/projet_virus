package com.aston.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aston.exceptions.NotFoundException;
import com.aston.models.elastic.IndicatorHealthPrepaES;
import com.aston.models.elastic.InfrastructureES;
import com.aston.models.elastic.UHCES;
import com.aston.models.mongo.Indicator_health_preparation;
import com.aston.models.mongo.Infrastructure;
import com.aston.models.mongo.Universal_health_coverage;
import com.aston.repositories.elastic.IndicatorHealthPrepaESRepository;
import com.aston.repositories.elastic.InfrastructureESRepository;
import com.aston.repositories.elastic.UHCESRepository;
import com.aston.repositories.mongo.IndicatorHealthPrepaMongoRepository;
import com.aston.repositories.mongo.InfrastructureMongoRepository;
import com.aston.repositories.mongo.UHCMongoRepository;
import com.aston.services.IndicatorHealthPrepaService;
import com.aston.services.InfrastructureService;
import com.aston.services.UHCService;


@Service
public class IndicatorHealthPrepaServiceImpl implements IndicatorHealthPrepaService {

	@Autowired IndicatorHealthPrepaMongoRepository indicatorHealthPrepaRepository;
	@Autowired IndicatorHealthPrepaESRepository indicatorHealthPrepaESRepository;

	@Override
	public List<Indicator_health_preparation> findAll() {
		List<Indicator_health_preparation> liste = this.indicatorHealthPrepaRepository.findAll();
		
		List<IndicatorHealthPrepaES> listeES = new ArrayList<>();
		int cpt = 1;
		for(Indicator_health_preparation i : liste)
		{
			
			IndicatorHealthPrepaES infES = new IndicatorHealthPrepaES(i);
			listeES.add(infES);
			cpt++;
			if(cpt==10000)
			{
				this.indicatorHealthPrepaESRepository.saveAll(listeES);
				cpt=1;
				listeES = new ArrayList<>();
			}
		}
		this.indicatorHealthPrepaESRepository.saveAll(listeES);
		return liste;
	}
	
	@Override
	public Indicator_health_preparation findById(String id) {
		Optional<Indicator_health_preparation> inf  = this.indicatorHealthPrepaRepository.findById(id);
		if (!inf.isPresent())
			throw new NotFoundException(id, Indicator_health_preparation.class.getSimpleName());
		
		return inf.get();
	}
	

}
