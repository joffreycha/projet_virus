package com.aston.models.elastic;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.aston.models.mongo.Epidemics_sars;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document(indexName = "project_epidemics_sars")
@Data
@NoArgsConstructor
public class SarsES{

	@Id private String id;
	
	private String country;
	
	private LocalDate date;
	
	private int deaths;
	private int cumul_deaths;
	private int cases;
	private int cumul_cases;

	public SarsES(Epidemics_sars s) {
		this.id = s.getId();
		this.country = s.getCountry();
		this.date = s .getDate();
		this.deaths = s.getDeaths();
		this.cumul_deaths = s.getCumul_deaths();
		this.cases = s.getCases();
		this.cumul_cases = s.getCumul_cases();
	}
    
    
}
