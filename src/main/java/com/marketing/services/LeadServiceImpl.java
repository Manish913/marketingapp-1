package com.marketing.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketing.entities.Lead;
import com.marketing.repository.LeadRepository;
@Service         //after using this annotation this class becomes spring boot class
public class LeadServiceImpl implements LeadService {
	//we are doing here inheritence and pollymorphism

	@Autowired  //here we are creating object of repository that has method to connect the database
	private LeadRepository leadrepo;
	 
	//this is service layer it is calling repository layer
	@Override
	public void saveLead(Lead lead) {
       leadrepo.save(lead);
       //it connects to database
	}

	@Override
	public List<Lead> listLeads() {
            List<Lead> leads = leadrepo.findAll();
		return leads;
	}

	@Override
	public void deleteById(long id) {
       leadrepo.deleteById(id);		
	}

	@Override
	public Lead getOneLead(long id) {
      Optional<Lead> findById = leadrepo.findById(id);
      Lead lead = findById.get();
		return lead;
	}


}
