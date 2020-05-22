package com.aston.models.elastic;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.aston.models.mongo.Sanitation_hygiene;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document(indexName = "project_health_indicators_sanitation_hygiene")
@Data
@NoArgsConstructor
public class SanitationES{

	@Id private String id;
	
	private String GHO_code;
	private String sanitation_hygiene;
	private int year;
	private String region_code;
	private String region;
	private String country_code;
	private String country;
	private String residence_area_type_code;
	private String residence_area_type;
	
    private int nb_sanitation_hygiene;
    
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
		this.nb_sanitation_hygiene = inf.getNb_sanitation_hygiene();
		this.comments = inf.getComments();
	}
    
    
}
