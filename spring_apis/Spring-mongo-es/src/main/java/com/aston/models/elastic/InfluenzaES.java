package com.aston.models.elastic;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.aston.models.mongo.Influenza;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document(indexName = "epidemics_influenza")
@Data
@NoArgsConstructor
public class InfluenzaES{

	@Id private String id;
	
	private String country;
	private String who_region;
	private String region;
	
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

	public InfluenzaES(Influenza inf) {
		this.id = inf.getId();
		this.country = inf.getCountry();
		this.who_region = inf.getWho_region();
		this.region = inf.getRegion();
		this.dateds = inf.getDateds();
		this.datefs = inf.getDatefs();
		this.collected = inf.getCollected();
		this.processed = inf.getProcessed();
		this.type_A_H1 = inf.getType_A_H1();
		this.type_A_H1N1 = inf.getType_A_H1N1();
		this.type_A_H3 = inf.getType_A_H3();
		this.type_A_H5 = inf.getType_A_H5();
		this.type_A_NS = inf.getType_A_NS();
		this.type_A_total = inf.getType_A_total();
		this.type_B_Yamata = inf.getType_B_Yamata();;
		this.type_B_Victoria = inf.getType_B_Victoria();
		this.type_B_ND = inf.getType_B_ND();
		this.type_B_total = inf.getType_B_total();
		this.total_positives = inf.getTotal_positives();
		this.total_negatives = inf.getTotal_negatives();
		ILI = inf.getILI();
	}
    
    
}
