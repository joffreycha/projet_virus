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
public class Sanitation{
	
	@Id private String id;
	
	private String GHO_code;
	private String sanitation_hygiene;
	private String year;
	private String region_code;
	private String region;
	private String country_code;
	private String country;
	private String residence_area_type_code;
	private String residence_area_type;
	
    private int nb;
    
    private String comments;
}
