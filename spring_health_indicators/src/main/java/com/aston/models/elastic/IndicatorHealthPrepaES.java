package com.aston.models.elastic;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.aston.models.mongo.Current_health_expenditure;
import com.aston.models.mongo.Indicator_health_preparation;
import com.aston.models.mongo.Universal_health_coverage;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document(indexName = "epidemics_health_indicators_indicator_health_prepa")
@Data
@NoArgsConstructor
public class IndicatorHealthPrepaES{

	@Id private String id;
	
	private String GHO_code;
	private String version;
	private String year;
	private String region_code;
	private String region;
	private String country_code;
	private String country;
	
    private String indice_health_prepa;
    
    private String comments;

	public IndicatorHealthPrepaES(Indicator_health_preparation inf) {
		this.id = inf.getId();
		this.GHO_code = inf.getGHO_code();
		this.version = inf .getVersion();
		this.year = inf.getYear();
		this.region_code = inf.getRegion_code();
		this.region = inf.getRegion();
		this.country_code = inf.getCountry_code();
		this.country = inf.getCountry();
		this.indice_health_prepa = inf.getIndice_health_prepa();
		this.comments = inf.getComments();
	}
    
    
}
