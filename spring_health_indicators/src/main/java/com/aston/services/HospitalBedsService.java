package com.aston.services;

import java.util.List;

import com.aston.models.mongo.Current_health_expenditure;
import com.aston.models.mongo.Hospital_beds;


public interface HospitalBedsService {

	/**
	 * Récupère tous les enregistrements de Mongo
	 * @return liste d'InfluenzaMongo
	 */
	public List<Hospital_beds> findAll();
	
	/**
	 * Récupère un enregistrement de Mongo à partir de son id
	 * @param id l'id à rechercher
	 * @return l'enregistrement trouvé
	 */
	public Hospital_beds findById(String id);

	
}
