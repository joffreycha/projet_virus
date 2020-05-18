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

import com.aston.models.mongo.Epidemics_influenza;
import com.aston.services.InfluenzaService;

@RestController
@CrossOrigin
@RequestMapping("influenza")
public class InfluenzaController {

	@Autowired InfluenzaService influenzaService;
	
	@GetMapping("")
	public List<Epidemics_influenza> findAll() {
		return this.influenzaService.findAll();
	}
	
	@GetMapping("{id}")
	public Epidemics_influenza findById(@PathVariable String id) {
		return this.influenzaService.findById(id);
	}
}
