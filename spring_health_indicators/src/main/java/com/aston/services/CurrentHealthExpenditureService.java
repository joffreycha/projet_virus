package com.aston.services;

import java.util.List;

import com.aston.models.mongo.Current_health_expenditure;


public interface CurrentHealthExpenditureService {

	/**
	 * Récupère tous les enregistrements de Mongo
	 * @return liste d'InfluenzaMongo
	 */
	public List<Current_health_expenditure> findAll();
	
	/**
	 * Récupère un enregistrement de Mongo à partir de son id
	 * @param id l'id à rechercher
	 * @return l'enregistrement trouvé
	 */
	public Current_health_expenditure findById(String id);

	
}
