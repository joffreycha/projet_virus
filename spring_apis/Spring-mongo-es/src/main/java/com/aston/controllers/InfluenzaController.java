package com.aston.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aston.models.mongo.InfluenzaMongo;
import com.aston.services.InfluenzaService;

@RestController
@CrossOrigin
@RequestMapping("influenzas")
public class InfluenzaController {

	@Autowired InfluenzaService influenzaService;
	
	@GetMapping("")
	public List<InfluenzaMongo> findAll() {
		return this.influenzaService.findAll();
	}
}
