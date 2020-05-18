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
public class Epidemics_mers{
	
	@Id private String id;
	
	private String region;	
	
	private int year;
	private int week;
	
	private LocalDate week_start_date;
	private LocalDate week_end_date;
	
    private int new_cases;
}
