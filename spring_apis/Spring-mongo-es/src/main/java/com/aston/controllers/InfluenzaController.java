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

import com.aston.models.elastic.InfluenzaES;
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
	
	@PostMapping("")
	public InfluenzaES save(@RequestBody InfluenzaMongo inf) {
		return this.influenzaService.save(inf);
	}
	
	@GetMapping("{id}")
	public InfluenzaMongo findById(@PathVariable String id) {
		return this.influenzaService.findById(id);
	}
}
