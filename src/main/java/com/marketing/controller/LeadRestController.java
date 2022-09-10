package com.marketing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketing.entities.Lead;
import com.marketing.services.LeadService;

@RestController
@RequestMapping("/api/leads")  //it is URL that interact with database
public class LeadRestController {
	@Autowired
	private LeadService leadservice;
	
	@GetMapping    //it helps us to get all data from  the database in the form of JSON object
	public List<Lead> getAllLeads(){
		
		List<Lead> leads = leadservice.listLeads();
		return leads;
	}
	@PostMapping
	public void saveOneLead(@RequestBody Lead lead) {//here @RequestBody annotation it copy JSON object to Java object
		leadservice.saveLead(lead);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteOneLead(@PathVariable("id") long id) {
		leadservice.deleteById(id);
	}
	@PutMapping
	public void updateOneLead(@RequestBody Lead lead) {//here @RequestBody annotation it copy JSON object to Java object
		leadservice.saveLead(lead);
	}
	@GetMapping("/lead/{id}")
	public Lead getOneLead(@PathVariable("id") long id) {
		Lead lead = leadservice.getOneLead(id);
		return lead;
		
	}

}
