package com.marketing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketing.dto.LeadData;
import com.marketing.entities.Lead;
import com.marketing.services.LeadService;

@Controller//it is controller layer it calls service layer
//@SessionAttributes("lead")
public class LeadController {
	
	@Autowired  //here service layer is getting call
	private LeadService    leadservice;
	
	@RequestMapping("/createLead")
	public String viewCreateLeadPage() {
		return "create_lead";
	}
    @RequestMapping("/saveLead")
	public String saveOneLead(@ModelAttribute("lead") Lead lead ,ModelMap model) {
       leadservice.saveLead(lead);
       model.addAttribute("msg", "Lead is saved!!");
		return "create_lead";
	}
    @RequestMapping("/listall")
	public String listAllLeads(@ModelAttribute("lead") Lead lead ,ModelMap model) {
    	List<Lead> leads = leadservice.listLeads();
        model.addAttribute("leads",leads);
    	return "lead_search_result";
	}
    @RequestMapping("/delete")
    public String deleteOneLead(@RequestParam("id") long id,ModelMap modal) {
    	leadservice.deleteById(id);
    	
    	List<Lead> leads = leadservice.listLeads();
    	 modal.addAttribute("leads",leads);
    	return "lead_search_result";
    }
    @RequestMapping("/update")
    public String updateOneLead(@RequestParam("id") long id,ModelMap modal) {
    	Lead lead = leadservice.getOneLead(id);
    	modal.addAttribute("lead",lead);
    	
		return "update_lead";
    	
    }
    @RequestMapping("/updateLead")
    public String updateOneLead(LeadData data,ModelMap model) {
    	Lead lead=new Lead();
    	lead.setId(data.getId());
    	lead.setFirstName(data.getFirstName());
    	lead.setLastName(data.getLastName());
    	lead.setEmail(data.getEmail());
    	lead.setMobile(data.getMobile());
    	leadservice.saveLead(lead);
    	model.addAttribute("lead",lead);
    	List<Lead> leads = leadservice.listLeads();
   	 model.addAttribute("leads",leads);
   	return "lead_search_result";
    }


}
