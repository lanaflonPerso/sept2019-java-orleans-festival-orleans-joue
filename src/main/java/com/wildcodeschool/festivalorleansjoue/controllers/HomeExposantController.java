package com.wildcodeschool.festivalorleansjoue.controllers;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.wildcodeschool.festivalorleansjoue.services.ModelService;



@RestController
public class HomeExposantController {	
	

	@Autowired
	ModelService modelService;
	
	@GetMapping("/accueil_editeur") 
	public ModelAndView homeEditor() {
		
		modelService.setHomeModel("homeEditor");
		return modelService.getModel();	
	}
	

	@GetMapping("/accueil_boutique") 
	public ModelAndView homeshop() {
		
		modelService.setHomeModel("homeShop");
		return modelService.getModel();	
	}
	
	
	@GetMapping("/accueil_volontaires") 
	public ModelAndView homeVolunteers() {
	
		modelService.setHomeModel("homeVolunteers");
		return modelService.getModel();		
	}	
}