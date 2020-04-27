package com.aston.services;

import java.util.List;

import com.aston.models.elastic.InfluenzaES;
import com.aston.models.mongo.InfluenzaMongo;

public interface InfluenzaService {

	/**
	 * Récupère tous les enregistrements de Mongo
	 * @return liste d'InfluenzaMongo
	 */
	public List<InfluenzaMongo> findAll();
	
	/**
	 * Récupère un enregistrement de Mongo à partir de son id
	 * @param id l'id à rechercher
	 * @return l'enregistrement trouvé
	 */
	public InfluenzaMongo findById(String id);
	
	
	
	/**
	 * Convertit et sauvegarder l'objet Mongo en objet ElasticSearch 
	 * @param inf
	 * @return
	 */
	public InfluenzaES save(InfluenzaMongo inf);
}
