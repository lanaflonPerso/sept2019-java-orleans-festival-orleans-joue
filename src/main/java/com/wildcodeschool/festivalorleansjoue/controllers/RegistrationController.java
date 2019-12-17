package com.wildcodeschool.festivalorleansjoue.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.wildcodeschool.festivalorleansjoue.entity.Registration;
import com.wildcodeschool.festivalorleansjoue.repository.RegistrationRepository;
import com.wildcodeschool.festivalorleansjoue.services.ModelService;
import com.wildcodeschool.festivalorleansjoue.services.RegistrationService;


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

		registrationService.updateEditorRegistrationService(registration);
		
		//Set toast message
		ModelMap model = new ModelMap();
		model.addAttribute("hasSubscribe", "ok");

		return new ModelAndView("redirect:/accueil_editeur", model);
	}
}
