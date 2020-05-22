package com.aston.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aston.models.mongo.Universal_health_coverage;
import com.aston.services.UHCService;

@RestController
@CrossOrigin
@RequestMapping("assurances")
public class UHCController {

	@Autowired UHCService uhcService;
	
	@GetMapping("")
	public List<Universal_health_coverage> findAll() {
		return this.uhcService.findAll();
	}
	
	@GetMapping("{id}")
	public Universal_health_coverage findById(@PathVariable String id) {
		return this.uhcService.findById(id);
	}
}
