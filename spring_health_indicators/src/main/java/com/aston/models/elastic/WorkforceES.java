package com.aston.models.elastic;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.aston.models.mongo.Current_health_expenditure;
import com.aston.models.mongo.Universal_health_coverage;
import com.aston.models.mongo.Workforce;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document(indexName = "epidemics_health_indicators_workforce")
@Data
@NoArgsConstructor
public class WorkforceES{

	@Id private String id;
	
	private String GHO_code;
	private String job;
	private String year;
	private String region_code;
	private String region;
	private String country_code;
	private String country;
	
    private float nb_workforce;
    
    private String comments;

	public WorkforceES(Workforce inf) {
		this.id = inf.getId();
		this.GHO_code = inf.getGHO_code();
		this.job = inf .getJob();
		this.year = inf.getYear();
		this.region_code = inf.getRegion_code();
		this.region = inf.getRegion();
		this.country_code = inf.getCountry_code();
		this.country = inf.getCountry();
		this.nb_workforce = inf.getNb_workforce();
		this.comments = inf.getComments();
	}
    
    
}
