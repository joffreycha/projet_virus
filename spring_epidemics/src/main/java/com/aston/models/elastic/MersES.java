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
	
	private String region;	
	
	private int year;
	private int week;
	
	private LocalDate week_start_date;
	private LocalDate week_end_date;
	
    private int new_cases;

	public MersES(Epidemics_mers inf) {
		this.id = inf.getId();
		this.region = inf.getRegion();
		this.year = inf.getYear();
		this.week = inf.getWeek();
		this.week_start_date = inf.getWeek_start_date();
		this.week_end_date = inf.getWeek_end_date();
		this.new_cases = inf.getNew_cases();
	}
    
    
}
