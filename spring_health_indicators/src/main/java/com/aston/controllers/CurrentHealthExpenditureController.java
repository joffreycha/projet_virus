package com.aston.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aston.models.mongo.Current_health_expenditure;
import com.aston.models.mongo.Hospital_beds;
import com.aston.models.mongo.Infrastructure;
import com.aston.models.mongo.Universal_health_coverage;
import com.aston.services.CurrentHealthExpenditureService;
import com.aston.services.HospitalBedsService;
import com.aston.services.InfrastructureService;
import com.aston.services.UHCService;

@RestController
@CrossOrigin
@RequestMapping("depenses")
public class CurrentHealthExpenditureController {

	@Autowired CurrentHealthExpenditureService cheService;
	
	@GetMapping("")
	public List<Current_health_expenditure> findAll() {
		return this.cheService.findAll();
	}
	
	@GetMapping("{id}")
	public Current_health_expenditure findById(@PathVariable String id) {
		return this.cheService.findById(id);
	}
}
