package com.aston.models.elastic;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.aston.models.mongo.Epidemics_mers;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document(indexName = "project_epidemics_mers")
@Data
@NoArgsConstructor
public class MersES{

	@Id private String id;
	
	private String country;	
	
	private int year;
	private int week;
	
    private int cases;
    private int cumul_cases;

	public MersES(Epidemics_mers m) {
		this.id = m.getId();
		this.country = m.getCountry();
		this.year = m.getYear();
		this.week = m.getWeek();
		this.cases = m.getCases();
		this.cumul_cases = m.getCumul_cases();
	}
    
    
}
