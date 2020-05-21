package com.aston.models.elastic;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.aston.models.mongo.Current_health_expenditure;
import com.aston.models.mongo.Universal_health_coverage;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document(indexName = "project_health_indicators_current_health_expenditure")
@Data
@NoArgsConstructor
public class CurrentHealthExpenditureES{

	@Id private String id;
	
	private String GHO_code;
	private String current_health_expenditure;
	private String year;
	private String region_code;
	private String region;
	private String world_bank_income_group;
	private String country_code;
	private String country;
	
    private float indice_current_health_expenditure;
    
    private String comments;

	public CurrentHealthExpenditureES(Current_health_expenditure inf) {
		this.id = inf.getId();
		this.GHO_code = inf.getGHO_code();
		this.current_health_expenditure = inf .getCurrent_health_expenditure();
		this.year = inf.getYear();
		this.region_code = inf.getRegion_code();
		this.region = inf.getRegion();
		this.world_bank_income_group = inf.getWorld_bank_income_group();
		this.country_code = inf.getCountry_code();
		this.country = inf.getCountry();
		this.indice_current_health_expenditure = inf.getIndice_current_health_expenditure();
		this.comments = inf.getComments();
	}
    
    
}
