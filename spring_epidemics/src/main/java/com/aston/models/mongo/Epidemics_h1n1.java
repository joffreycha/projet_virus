package com.aston.models.mongo;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Epidemics_h1n1{
	
	@Id private String id;
	
	private String country;
	
	private LocalDate update_time;
	
	private int year;
	private int week;
	
    private int cases;
    private int deaths;
}
