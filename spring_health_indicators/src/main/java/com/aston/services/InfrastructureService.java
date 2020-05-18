package com.aston.services;

import java.util.List;

import com.aston.models.mongo.Infrastructure;


public interface InfrastructureService {

	/**
	 * Récupère tous les enregistrements de Mongo
	 * @return liste d'InfluenzaMongo
	 */
	public List<Infrastructure> findAll();
	
	/**
	 * Récupère un enregistrement de Mongo à partir de son id
	 * @param id l'id à rechercher
	 * @return l'enregistrement trouvé
	 */
	public Infrastructure findById(String id);

	
}
