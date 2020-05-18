package com.aston.models.elastic;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.aston.models.mongo.CurrentHealthExpenditure;
import com.aston.models.mongo.IndicatorHealthPrepa;
import com.aston.models.mongo.UHC;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document(indexName = "indicator_health_prepa")
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
	
    private String nb;
    
    private String comments;

	public IndicatorHealthPrepaES(IndicatorHealthPrepa inf) {
		this.id = inf.getId();
		this.GHO_code = inf.getGHO_code();
		this.version = inf .getVersion();
		this.year = inf.getYear();
		this.region_code = inf.getRegion_code();
		this.region = inf.getRegion();
		this.country_code = inf.getCountry_code();
		this.country = inf.getCountry();
		this.nb = inf.getNb();
		this.comments = inf.getComments();
	}
    
    
}
