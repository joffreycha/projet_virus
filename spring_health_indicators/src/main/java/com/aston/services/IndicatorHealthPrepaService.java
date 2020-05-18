package com.aston.services;

import java.util.List;

import com.aston.models.mongo.Indicator_health_preparation;


public interface IndicatorHealthPrepaService {

	/**
	 * Récupère tous les enregistrements de Mongo
	 * @return liste d'InfluenzaMongo
	 */
	public List<Indicator_health_preparation> findAll();
	
	/**
	 * Récupère un enregistrement de Mongo à partir de son id
	 * @param id l'id à rechercher
	 * @return l'enregistrement trouvé
	 */
	public Indicator_health_preparation findById(String id);

	
}
