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
public class Current_health_expenditure{
	
	@Id private String id;
	
	private String GHO_code;
	private String current_health_expenditure;
	private int year;
	private String region_code;
	private String region;
	private String world_bank_income_group;
	private String country_code;
	private String country;
	
    private float nb;
    
    private String comments;
}
