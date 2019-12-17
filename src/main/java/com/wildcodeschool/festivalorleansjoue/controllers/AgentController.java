package com.wildcodeschool.festivalorleansjoue.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.wildcodeschool.festivalorleansjoue.entity.Agent;
import com.wildcodeschool.festivalorleansjoue.repository.AgentRepository;
import com.wildcodeschool.festivalorleansjoue.repository.SocietyRepository;
import com.wildcodeschool.festivalorleansjoue.services.AgentService;
import com.wildcodeschool.festivalorleansjoue.services.RegistrationService;

@Controller	
public class AgentController {
	
	@Autowired
	private AgentRepository agentRepository;
	
	@Autowired
	private AgentService agentService;
	
	@Autowired
	private RegistrationService registrationService;
	
	@Autowired
	private SocietyRepository societyRepository;

	@PostMapping("/agent")
	public String getAll(Model model) {
		
		model.addAttribute("agent", agentRepository.findAll());
		return "agent";
	}

	
	@PostMapping("/addAgent")
	public ModelAndView postAgent (@ModelAttribute Agent agent) {
		
		agentService.addAgent(agent);
		ModelMap model = new ModelMap();
		model.addAttribute("Agent", agent);
		return new ModelAndView("redirect:/profil", model);
	}
	
	
	@PostMapping("/addRegistrationAgent")
    public ModelAndView postRegistrationAgent(@ModelAttribute Agent agent, Long registrationId, Long societyId) {
		
		agent.setSociety(societyRepository.getOne(societyId));
		agentService.addAgent(agent);
		registrationService.addRegistrationAgent(agent, registrationId);
		ModelMap model = new ModelMap();
		model.addAttribute("registrationId", registrationId);
		return new ModelAndView("redirect:/subscribeEditorModification", model);
    }
	
	
	@PostMapping("/deleteRegistrationAgent")
    public ModelAndView deleteAgent(@RequestParam Long agentRegistrationId, Long registrationId) {
		System.out.println("controller de delete");
		Agent agent = agentRepository.getOne(agentRegistrationId);
		registrationService.deleteRegistrationAgent(agent, registrationId);
		agentService.deleteAgent(agent);
		ModelMap model = new ModelMap();
		model.addAttribute("registrationId", registrationId);
		return new ModelAndView("redirect:/subscribeEditorModification", model);
    }
	
}

