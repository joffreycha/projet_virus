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

import com.aston.models.mongo.Infrastructure;
import com.aston.models.mongo.Sanitation_hygiene;
import com.aston.models.mongo.Universal_health_coverage;
import com.aston.services.InfrastructureService;
import com.aston.services.SanitationService;
import com.aston.services.UHCService;

@RestController
@CrossOrigin
@RequestMapping("sanitations")
public class SanitationController {

	@Autowired SanitationService sanitationService;
	
	@GetMapping("")
	public List<Sanitation_hygiene> findAll() {
		return this.sanitationService.findAll();
	}
	
	@GetMapping("{id}")
	public Sanitation_hygiene findById(@PathVariable String id) {
		return this.sanitationService.findById(id);
	}
}
