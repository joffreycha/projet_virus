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

import com.aston.models.mongo.Hospital_beds;
import com.aston.models.mongo.Infrastructure;
import com.aston.models.mongo.Universal_health_coverage;
import com.aston.services.HospitalBedsService;
import com.aston.services.InfrastructureService;
import com.aston.services.UHCService;

@RestController
@CrossOrigin
@RequestMapping("beds")
public class HospitalBedsController {

	@Autowired HospitalBedsService bedsService;
	
	@GetMapping("")
	public List<Hospital_beds> findAll() {
		return this.bedsService.findAll();
	}
	
	@GetMapping("{id}")
	public Hospital_beds findById(@PathVariable String id) {
		return this.bedsService.findById(id);
	}
}
