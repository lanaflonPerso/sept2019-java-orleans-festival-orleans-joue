package com.wildcodeschool.festivalorleansjoue.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.wildcodeschool.festivalorleansjoue.services.ModelService;

@RestController
public class HomeExposantController {

	@Autowired
	ModelService modelService;
	
	
	
	@GetMapping("/accueil_editeur")
	public ModelAndView homeEditor(@RequestParam (name="hasSubscribe", required = false) Optional<String> hasSubscribe){
		modelService.setHomeModel("homeEditor", hasSubscribe);
		return modelService.getModel();
	}
	

	@GetMapping("/accueil_boutique")
	public ModelAndView homeShop(@RequestParam (name="hasSubscribe", required = false) Optional<String> hasSubscribe) {

		modelService.setHomeModel("homeShop", hasSubscribe);
		return modelService.getModel();
	}
	

	@GetMapping("/accueil_volontaires")
	public ModelAndView homeVolunteers(@RequestParam (name="hasSubscribe", required = false) Optional<String> hasSubscribe){

		modelService.setHomeModel("homeVolunteers", hasSubscribe);
		return modelService.getModel();
	}
}