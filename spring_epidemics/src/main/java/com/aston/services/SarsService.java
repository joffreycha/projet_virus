package com.aston.services;

import java.util.List;
import com.aston.models.mongo.Epidemics_sars;


public interface SarsService {

	/**
	 * Récupère tous les enregistrements de Mongo
	 * @return liste d'InfluenzaMongo
	 */
	public List<Epidemics_sars> findAll();
	
	/**
	 * Récupère un enregistrement de Mongo à partir de son id
	 * @param id l'id à rechercher
	 * @return l'enregistrement trouvé
	 */
	public Epidemics_sars findById(String id);

	
}
