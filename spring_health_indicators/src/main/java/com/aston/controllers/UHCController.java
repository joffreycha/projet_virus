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

import com.aston.models.mongo.UHC;
import com.aston.services.UHCService;

@RestController
@CrossOrigin
@RequestMapping("UHC")
public class UHCController {

	@Autowired UHCService uhcService;
	
	@GetMapping("")
	public List<UHC> findAll() {
		return this.uhcService.findAll();
	}
	
	@GetMapping("{id}")
	public UHC findById(@PathVariable String id) {
		return this.uhcService.findById(id);
	}
}
