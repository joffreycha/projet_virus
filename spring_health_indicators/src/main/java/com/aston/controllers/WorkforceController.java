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
import com.aston.models.mongo.Workforce;
import com.aston.services.InfrastructureService;
import com.aston.services.UHCService;
import com.aston.services.WorkforceService;

@RestController
@CrossOrigin
@RequestMapping("workforces")
public class WorkforceController {

	@Autowired WorkforceService workforceService;
	
	@GetMapping("")
	public List<Workforce> findAll() {
		return this.workforceService.findAll();
	}
	
	@GetMapping("{id}")
	public Workforce findById(@PathVariable String id) {
		return this.workforceService.findById(id);
	}
}
