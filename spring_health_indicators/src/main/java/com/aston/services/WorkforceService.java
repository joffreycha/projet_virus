package com.aston.services;

import java.util.List;

import com.aston.models.mongo.Universal_health_coverage;
import com.aston.models.mongo.Workforce;


public interface WorkforceService {

	/**
	 * Récupère tous les enregistrements de Mongo
	 * @return liste d'InfluenzaMongo
	 */
	public List<Workforce> findAll();
	
	/**
	 * Récupère un enregistrement de Mongo à partir de son id
	 * @param id l'id à rechercher
	 * @return l'enregistrement trouvé
	 */
	public Workforce findById(String id);

	
}
