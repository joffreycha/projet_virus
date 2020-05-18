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

import com.aston.models.mongo.Epidemics_h1n1;
import com.aston.services.H1n1Service;

@RestController
@CrossOrigin
@RequestMapping("h1n1")
public class H1n1Controller {

	@Autowired H1n1Service h1n1Service;
	
	@GetMapping("")
	public List<Epidemics_h1n1> findAll() {
		return this.h1n1Service.findAll();
	}
	
	@GetMapping("{id}")
	public Epidemics_h1n1 findById(@PathVariable String id) {
		return this.h1n1Service.findById(id);
	}
}
