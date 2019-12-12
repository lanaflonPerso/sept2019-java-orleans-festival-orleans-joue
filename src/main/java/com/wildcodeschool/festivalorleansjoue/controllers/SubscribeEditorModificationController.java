package com.wildcodeschool.festivalorleansjoue.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.wildcodeschool.festivalorleansjoue.entity.Registration;
import com.wildcodeschool.festivalorleansjoue.services.ModelService;

@RestController
public class SubscribeEditorModificationController {
	
	@Autowired
	ModelService modelService;
	
	
	@PostMapping("/subscribeEditorModification")
	public ModelAndView subscribeEditor(@ModelAttribute Registration registration) {
		
		modelService.setSubscribeEditorModificationModel("subscribeEditorModification",registration);
		return modelService.getModel();
	}
}
