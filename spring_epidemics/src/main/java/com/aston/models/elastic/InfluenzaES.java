package com.aston.models.elastic;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.aston.models.mongo.Epidemics_influenza;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document(indexName = "epidemics_influenza")
@Data
@NoArgsConstructor
public class InfluenzaES{

	@Id private String id;
	
	private String country;
	
	private LocalDate date;
	
	private String type;
	
	private int cases;
	private int cumul_cases;

	public InfluenzaES(Epidemics_influenza inf) {
		this.id = inf.getId();
		this.country = inf.getCountry();
		this.date = inf .getDate();
		this.type = inf.getType();
		this.cases = inf.getCases();
		this.cumul_cases = inf.getCumul_cases();
	}
    
    
}
