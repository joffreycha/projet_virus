package com.aston.models.elastic;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.aston.models.mongo.Epidemics_influenza;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document(indexName = "epidemics_influenza")
@Data
@NoArgsConstructor
public class InfluenzaES{

	@Id private String id;
	
	private String country;
	
	private LocalDate date;
	
	private int AH1;
	private int AH1N12009;
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

	public InfluenzaES(Epidemics_influenza inf) {
		this.id = inf.getId();
		this.country = inf.getCountry();
		this.date = inf .getDate();
		this.AH1 = inf.getAH1();
		this.AH1N12009 = inf.getAH1N12009();
		this.AH3 = inf.getAH3();
		this.AH5 = inf.getAH5();
		this.ANOTSUBTYPED = inf.getANOTSUBTYPED();
		this.INF_A = inf.getINF_A();
		this.ALL_INF = inf.getALL_INF();
		this.ALL_INF2 = inf.getALL_INF2();
	}
    
    
}
