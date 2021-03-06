package com.aston.services;

import java.util.List;

import com.aston.models.mongo.Universal_health_coverage;


public interface UHCService {

	/**
	 * Récupère tous les enregistrements de Mongo
	 * @return liste d'InfluenzaMongo
	 */
	public List<Universal_health_coverage> findAll();
	
	/**
	 * Récupère un enregistrement de Mongo à partir de son id
	 * @param id l'id à rechercher
	 * @return l'enregistrement trouvé
	 */
	public Universal_health_coverage findById(String id);

	
}
