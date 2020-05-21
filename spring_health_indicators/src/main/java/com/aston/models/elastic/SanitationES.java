package com.aston.models.elastic;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.aston.models.mongo.Current_health_expenditure;
import com.aston.models.mongo.Sanitation_hygiene;
import com.aston.models.mongo.Universal_health_coverage;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document(indexName = "epidemics_health_indicators_sanitation_hygiene")
@Data
@NoArgsConstructor
public class SanitationES{

	@Id private String id;
	
	private String GHO_code;
	private String sanitation_hygiene;
	private String year;
	private String region_code;
	private String region;
	private String country_code;
	private String country;
	private String residence_area_type_code;
	private String residence_area_type;
	
    private int nb;
    
    private String comments;

	public SanitationES(Sanitation_hygiene inf) {
		this.id = inf.getId();
		this.GHO_code = inf.getGHO_code();
		this.sanitation_hygiene = inf .getSanitation_hygiene();
		this.year = inf.getYear();
		this.region_code = inf.getRegion_code();
		this.region = inf.getRegion();
		this.country_code = inf.getCountry_code();
		this.country = inf.getCountry();
		this.residence_area_type_code = inf.getResidence_area_type_code();
		this.residence_area_type = inf.getResidence_area_type();
		this.nb = inf.getNb();
		this.comments = inf.getComments();
	}
    
    
}
