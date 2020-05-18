package com.aston.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aston.exceptions.NotFoundException;
import com.aston.models.elastic.HospitalBedsES;
import com.aston.models.mongo.Hospital_beds;
import com.aston.repositories.elastic.HospitalBedsESRepository;
import com.aston.repositories.mongo.HospitalBedsMongoRepository;
import com.aston.services.HospitalBedsService;


@Service
public class HospitalBedsServiceImpl implements HospitalBedsService {

	@Autowired HospitalBedsMongoRepository hospitalBedsRepository;
	@Autowired HospitalBedsESRepository hospitalBedsESRepository;

	@Override
	public List<Hospital_beds> findAll() {
		List<Hospital_beds> liste = this.hospitalBedsRepository.findAll();
		
		List<HospitalBedsES> listeES = new ArrayList<>();
		int cpt = 1;
		for(Hospital_beds i : liste)
		{
			
			HospitalBedsES infES = new HospitalBedsES(i);
			listeES.add(infES);
			cpt++;
			if(cpt==10000)
			{
				this.hospitalBedsESRepository.saveAll(listeES);
				cpt=1;
				listeES = new ArrayList<>();
			}
		}
		this.hospitalBedsESRepository.saveAll(listeES);
		return liste;
	}
	
	@Override
	public Hospital_beds findById(String id) {
		Optional<Hospital_beds> inf  = this.hospitalBedsRepository.findById(id);
		if (!inf.isPresent())
			throw new NotFoundException(id, Hospital_beds.class.getSimpleName());
		
		return inf.get();
	}
	

}
