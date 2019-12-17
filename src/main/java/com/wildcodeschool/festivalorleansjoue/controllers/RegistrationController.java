package com.wildcodeschool.festivalorleansjoue.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.wildcodeschool.festivalorleansjoue.entity.Event;
import com.wildcodeschool.festivalorleansjoue.entity.Registration;
import com.wildcodeschool.festivalorleansjoue.repository.RegistrationRepository;
import com.wildcodeschool.festivalorleansjoue.services.ModelService;
import com.wildcodeschool.festivalorleansjoue.services.RegistrationService;
import com.wildcodeschool.festivalorleansjoue.utils.MathUtils;


@RestController
public class RegistrationController {
	
	@Autowired
	ModelService modelService;
	
	@Autowired
	RegistrationService registrationService;
	
	@Autowired
	RegistrationRepository registrationRepository;
	
	
	@PostMapping(value = "/deleteEditorRegistration")
	public ModelAndView deleteEditorRegistration(@RequestParam Long registrationId) {
		
		registrationService.deleteEditorRegistration(registrationId);		
		ModelMap model = new ModelMap();
		model.addAttribute("hasSubscribe", "delete");
		return new ModelAndView("redirect:/accueil_editeur", model);
	}
	
	
	@PostMapping(value = "/addGameToRegistration")
	public ModelAndView addGameToRegistration(@RequestParam Long registrationId,
											  @RequestParam(name="gameId") Long gameId) {
		
		System.out.println("registration:" + registrationId);
		System.out.println("game:" + gameId);
		registrationService.addRegistrationGame(gameId, registrationId);		
		
		ModelMap model = new ModelMap();
		model.addAttribute("registrationId", registrationId);
		
		return new ModelAndView("redirect:/subscribeEditorModification", model);
	}

	/*
	public String addGameToRegistration(@MatrixVariable MultiValueMap<String, String> parameters) {
		for (Entry<String, List<String>> entry: parameters.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
					return "toto";
	}
	*/

	@PostMapping("/updateEditorRegistration")
	public ModelAndView updateEditorRegistration(@ModelAttribute Registration registration) {

		Registration originalReg = registrationRepository.getOne(registration.getId());
		 
		//Tables quantity
		Event event = originalReg.getEvent();
		if (registration.getTablesQuantity() > event.getMaxTablesPerEditor()) {
			registration.setTablesQuantity(event.getMaxTablesPerEditor());
		} else if (registration.getTablesQuantity() < 0) {
			registration.setTablesQuantity(0);
		}
		
		//Registration cost
		int tablesQuantity = registration.getTablesQuantity();
		float tablePrice = event.getPricePerTable();		
		float saleOptionPrice = (registration.isSaleOption()) ? event.getSaleOptionPrice() : 0.00f;
		float registrationCost = MathUtils.registrationCost(tablesQuantity, tablePrice, saleOptionPrice);		
		registration.setRegistrationCost(registrationCost);
		
		//Update changes
		originalReg.setTablesQuantity(registration.getTablesQuantity());
		originalReg.setElectricalSupplyNeed(registration.isElectricalSupplyNeed());
		originalReg.setSaleOption(registration.isSaleOption());
		originalReg.setAgentProvided(registration.isAgentProvided());
		originalReg.setVolunteersNeed(registration.isVolunteersNeed());
		originalReg.setComments(registration.getComments());
		originalReg.setRegistrationCost(registration.getRegistrationCost());	
		registrationRepository.save(originalReg);
		
		//Set toast message
		ModelMap model = new ModelMap();
		model.addAttribute("hasSubscribe", "ok");
		
//		return modelService.getModel();
		return new ModelAndView("redirect:/accueil_editeur", model);
	}
}
