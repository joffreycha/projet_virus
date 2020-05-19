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
public class Epidemics_sars{
	
	@Id private String id;
	
	private String country;
	
	private LocalDate date;
	
	private int deaths;
	private int cumul_deaths;
	private int cases;
	private int cumul_cases;
}
