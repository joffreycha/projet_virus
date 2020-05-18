package com.aston.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aston.exceptions.NotFoundException;
import com.aston.models.elastic.UHCES;
import com.aston.models.mongo.UHC;
import com.aston.repositories.elastic.UHCESRepository;
import com.aston.repositories.mongo.UHCMongoRepository;
import com.aston.services.UHCService;


@Service
public class UHCServiceImpl implements UHCService {

	@Autowired UHCMongoRepository uhcRepository;
	@Autowired UHCESRepository uhcESRepository;

	@Override
	public List<UHC> findAll() {
		List<UHC> liste = this.uhcRepository.findAll();
		
		List<UHCES> listeES = new ArrayList<>();
		int cpt = 1;
		for(UHC i : liste)
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
	public UHC findById(String id) {
		Optional<UHC> inf  = this.uhcRepository.findById(id);
		if (!inf.isPresent())
			throw new NotFoundException(id, UHC.class.getSimpleName());
		
		return inf.get();
	}
	

}
