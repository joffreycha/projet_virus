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
import com.aston.models.mongo.Universal_health_coverage;
import com.aston.services.InfrastructureService;
import com.aston.services.UHCService;

@RestController
@CrossOrigin
@RequestMapping("infrastructures")
public class InfrastructureController {

	@Autowired InfrastructureService infrastructureService;
	
	@GetMapping("")
	public List<Infrastructure> findAll() {
		return this.infrastructureService.findAll();
	}
	
	@GetMapping("{id}")
	public Infrastructure findById(@PathVariable String id) {
		return this.infrastructureService.findById(id);
	}
}
