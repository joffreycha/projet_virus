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

import com.aston.models.mongo.Epidemics_mers;
import com.aston.services.MersService;

@RestController
@CrossOrigin
@RequestMapping("mers")
public class MersController {

	@Autowired MersService mersService;
	
	@GetMapping("")
	public List<Epidemics_mers> findAll() {
		return this.mersService.findAll();
	}
	
	@GetMapping("{id}")
	public Epidemics_mers findById(@PathVariable String id) {
		return this.mersService.findById(id);
	}
}
