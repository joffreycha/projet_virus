package com.aston.models.mongo;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.aston.models.elastic.UHCES;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Workforce{
	
	@Id private String id;
	
	private String GHO_code;
	private String job;
	private String year;
	private String region_code;
	private String region;
	private String country_code;
	private String country;
	
    private float nb;
    
    private String comments;
}
