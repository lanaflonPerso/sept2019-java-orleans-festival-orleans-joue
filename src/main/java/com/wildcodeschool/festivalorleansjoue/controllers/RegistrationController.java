package com.wildcodeschool.festivalorleansjoue.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.wildcodeschool.festivalorleansjoue.services.ModelService;
import com.wildcodeschool.festivalorleansjoue.services.RegistrationService;


@RestController
public class RegistrationController {
	
	@Autowired
	ModelService modelService;
	
	@Autowired
	RegistrationService registrationService;
	
	
	@PostMapping(value = "/deleteEditorRegistration")
	public ModelAndView deleteEditorRegistration(@RequestParam Long registrationId) {
		
		registrationService.deleteEditorRegistration(registrationId);		
		ModelMap model = new ModelMap();
		model.addAttribute("hasSubscribe", "delete");
		return new ModelAndView("redirect:/accueil_editeur", model);
	}
}
