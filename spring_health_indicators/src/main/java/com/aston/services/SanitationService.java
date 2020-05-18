package com.aston.services;

import java.util.List;

import com.aston.models.mongo.Sanitation_hygiene;
import com.aston.models.mongo.Universal_health_coverage;


public interface SanitationService {

	/**
	 * Récupère tous les enregistrements de Mongo
	 * @return liste d'InfluenzaMongo
	 */
	public List<Sanitation_hygiene> findAll();
	
	/**
	 * Récupère un enregistrement de Mongo à partir de son id
	 * @param id l'id à rechercher
	 * @return l'enregistrement trouvé
	 */
	public Sanitation_hygiene findById(String id);

	
}
