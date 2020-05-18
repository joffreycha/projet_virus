package com.aston.services;

import java.util.List;

import com.aston.models.mongo.Epidemics_h1n1;


public interface H1n1Service {

	/**
	 * Récupère tous les enregistrements de Mongo
	 * @return liste d'InfluenzaMongo
	 */
	public List<Epidemics_h1n1> findAll();
	
	/**
	 * Récupère un enregistrement de Mongo à partir de son id
	 * @param id l'id à rechercher
	 * @return l'enregistrement trouvé
	 */
	public Epidemics_h1n1 findById(String id);

	
}
