package com.aston.models.elastic;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.aston.models.mongo.Epidemics_h1n1;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document(indexName = "epidemics_h1n1")
@Data
@NoArgsConstructor
public class H1n1ES{

	@Id private String id;
	
	private String country;
	
	private LocalDate date;
	
    private int cases;
    private int cumul_cases;
    private int deaths;
    private int cumul_deaths;

	public H1n1ES(Epidemics_h1n1 h) {
		this.id = h.getId();
		this.country = h.getCountry();
		this.date = h.getDate();
		this.cases = h.getCases();
		this.cumul_cases = h.getCumul_cases();
		this.deaths = h.getDeaths();
		this.cumul_deaths = h.getCumul_deaths();
	}
    
    
}
