package com.aston.models.elastic;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.aston.models.mongo.Epidemics_mers;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document(indexName = "epidemics_mers")
@Data
@NoArgsConstructor
public class MersES{

	@Id private String id;
	
	private String country;	
	
	private int year;
	private int week;
	
    private int cases;

	public MersES(Epidemics_mers inf) {
		this.id = inf.getId();
		this.country = inf.getCountry();
		this.year = inf.getYear();
		this.week = inf.getWeek();
		this.cases = inf.getCases();
	}
    
    
}
