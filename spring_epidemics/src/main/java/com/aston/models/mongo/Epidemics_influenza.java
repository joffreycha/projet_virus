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
public class Epidemics_influenza{
	
	@Id private String id;
	
	private String country;
	
	private int year;
	private int week;
	
	private LocalDate week_start_date;
	private LocalDate week_end_date;
	
	private int AH1;
	private int  AH1N12009;
	private int AH3;
	private int AH5;
	private int ANOTSUBTYPED;
	private int INF_A;
	private int BYAMAGATA;
	private int BVICTORIA;
	private int BNOTDETERMINED;
	private int INF_B;
	private int ALL_INF;
	private int ALL_INF2;
	
}
