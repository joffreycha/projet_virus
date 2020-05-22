package com.aston.models.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Indicator_health_preparation{
	
	@Id private String id;
	
	private String GHO_code;
	private String version;
	private int year;
	private String region_code;
	private String region;
	private String country_code;
	private String country;
	
    private int indice_health_prepa;
    
    private String comments;
}
