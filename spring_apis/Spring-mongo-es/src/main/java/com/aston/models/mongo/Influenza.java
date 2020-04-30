package com.aston.models.mongo;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.aston.models.elastic.InfluenzaES;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Influenza{
	
	@Id private String id;
	
	private String country;
	private String who_region;
	private String region;
	
	private int year;
	private int week;
	private LocalDate dateds;
	private LocalDate datefs;
	
	private String collected;
	private String processed;
	
	private int type_A_H1;
	private int type_A_H1N1;
    private int type_A_H3;
    private int type_A_H5;
    private int type_A_NS;
    private int type_A_total;
    private int type_B_Yamata;
    private int type_B_Victoria;
    private int type_B_ND;
    private int type_B_total;
    private int total_positives;
    private int total_negatives;
    
    private String ILI;
}
