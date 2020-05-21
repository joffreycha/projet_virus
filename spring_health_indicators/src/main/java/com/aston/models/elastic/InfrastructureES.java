package com.aston.models.elastic;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.aston.models.mongo.Infrastructure;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document(indexName = "epidemics_health_indicators_infrastructure")
@Data
@NoArgsConstructor
public class InfrastructureES{

	@Id private String id;
	
	private String GHO_code;
	private String infrastructure;
	private String year;
	private String region_code;
	private String region;
	private String country_code;
	private String country;
	
    private float nb_infrastructure;
    
    private String comments;

	public InfrastructureES(Infrastructure inf) {
		this.id = inf.getId();
		this.GHO_code = inf.getGHO_code();
		this.infrastructure = inf .getInfrastructure();
		this.year = inf.getYear();
		this.region_code = inf.getRegion_code();
		this.region = inf.getRegion();
		this.country_code = inf.getCountry_code();
		this.country = inf.getCountry();
		this.nb_infrastructure = inf.getNb_infrastructure();
		this.comments = inf.getComments();
	}
    
    
}
