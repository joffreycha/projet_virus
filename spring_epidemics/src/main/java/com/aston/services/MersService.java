package com.aston.services;

import java.util.List;
import com.aston.models.mongo.Epidemics_mers;


public interface MersService {

	/**
	 * Récupère tous les enregistrements de Mongo
	 * @return liste d'InfluenzaMongo
	 */
	public List<Epidemics_mers> findAll();
	
	/**
	 * Récupère un enregistrement de Mongo à partir de son id
	 * @param id l'id à rechercher
	 * @return l'enregistrement trouvé
	 */
	public Epidemics_mers findById(String id);

	
}
