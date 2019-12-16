package com.wildcodeschool.festivalorleansjoue.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	
	@RequestMapping(value = "/deleteEditorRegistration", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView deleteEditorRegistration(@RequestParam Long registrationId) {
		
		registrationService.deleteEditorRegistration(registrationId);		
		ModelMap model = new ModelMap();
		return new ModelAndView("redirect:/accueil_editeur", model);
	}
}
