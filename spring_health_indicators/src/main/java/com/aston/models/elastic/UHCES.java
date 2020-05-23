package com.aston.models.elastic;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.aston.models.mongo.Universal_health_coverage;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document(indexName = "project_health_indicators_uhc")
@Data
@NoArgsConstructor
public class UHCES{

	@Id private String id;
	
	private String gho_code;
	private String uhc;
	private int year;
	private String region_code;
	private String region;
	private String country_code;
	private String country;
	private String residence_area_type_code;
	private String residence_area_type;
	
    private float nb;
    
    private String comments;

	public UHCES(Universal_health_coverage inf) {
		this.id = inf.getId();
		this.gho_code = inf.getGHO_code();
		this.uhc = inf .getUHC();
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
