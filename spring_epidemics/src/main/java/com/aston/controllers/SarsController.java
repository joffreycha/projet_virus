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

import com.aston.models.mongo.Epidemics_sars;
import com.aston.services.SarsService;

@RestController
@CrossOrigin
@RequestMapping("sars")
public class SarsController {

	@Autowired SarsService sarsService;
	
	@GetMapping("")
	public List<Epidemics_sars> findAll() {
		return this.sarsService.findAll();
	}
	
	@GetMapping("{id}")
	public Epidemics_sars findById(@PathVariable String id) {
		return this.sarsService.findById(id);
	}
}
