package com.aston.models.elastic;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.aston.models.mongo.Epidemics_sars;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document(indexName = "epidemics_sars")
@Data
@NoArgsConstructor
public class SarsES{

	@Id private String id;
	
	private String country;
	
	private LocalDate date;
	
	private int year;
	private int week;
	
	private int deaths;
	private int cumulative_number_of_cases;
	private int recovered;

	public SarsES(Epidemics_sars inf) {
		this.id = inf.getId();
		this.country = inf.getCountry();
		this.date = inf .getDate();
		this.year = inf.getYear();
		this.week = inf.getWeek();
		this.deaths = inf.getDeaths();
		this.cumulative_number_of_cases = inf.getCumulative_number_of_cases();
		this.recovered = inf.getRecovered();
		this.country = inf.getCountry();
	}
    
    
}
