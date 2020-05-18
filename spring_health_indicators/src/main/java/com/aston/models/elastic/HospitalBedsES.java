package com.aston.models.elastic;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.aston.models.mongo.Hospital_beds;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document(indexName = "hospital_beds")
@Data
@NoArgsConstructor
public class HospitalBedsES{

	@Id private String id;
	
	private String year;
	private String region_code;
	private String region;
	private String country_code;
	private String country;
	
    private int nb;
    
    private String comments;

	public HospitalBedsES(Hospital_beds inf) {
		this.id = inf.getId();
		this.year = inf.getYear();
		this.region_code = inf.getRegion_code();
		this.region = inf.getRegion();
		this.country_code = inf.getCountry_code();
		this.country = inf.getCountry();
		this.nb = inf.getNb();
		this.comments = inf.getComments();
	}
    
    
}
