package com.aston.models.elastic;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.aston.models.mongo.Current_health_expenditure;
import com.aston.models.mongo.Universal_health_coverage;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document(indexName = "current_health_expenditure")
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
	
    private float nb;
    
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
		this.nb = inf.getNb();
		this.comments = inf.getComments();
	}
    
    
}
