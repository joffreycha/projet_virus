package com.aston.services;

import java.util.List;

import com.aston.models.mongo.Epidemics_influenza;


public interface InfluenzaService {

	/**
	 * Récupère tous les enregistrements de Mongo
	 * @return liste d'InfluenzaMongo
	 */
	public List<Epidemics_influenza> findAll();
	
	/**
	 * Récupère un enregistrement de Mongo à partir de son id
	 * @param id l'id à rechercher
	 * @return l'enregistrement trouvé
	 */
	public Epidemics_influenza findById(String id);

	
}
