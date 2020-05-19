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
    private int deaths;

	public H1n1ES(Epidemics_h1n1 inf) {
		this.id = inf.getId();
		this.country = inf.getCountry();
		this.date = inf .getDate();
		this.cases = inf.getCases();
		this.deaths = inf.getDeaths();
	}
    
    
}
