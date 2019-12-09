package com.wildcodeschool.festivalorleansjoue.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.wildcodeschool.festivalorleansjoue.services.ModelService;


	@RestController
	public class SubscribeEditorController {
		
		@Autowired
		ModelService modelService;
		
		@GetMapping("/subscribeEditor")
		public ModelAndView subscribeEditor() {

			modelService.setSubscribeEditorModel("subscribeEditor");
			return modelService.getModel();
		}
		
		@PostMapping("/inscription_editeur")
		public ModelAndView submitRegistration() {
			
			return new ModelAndView("redirect:/accueil_editeur"); 
		}
}
