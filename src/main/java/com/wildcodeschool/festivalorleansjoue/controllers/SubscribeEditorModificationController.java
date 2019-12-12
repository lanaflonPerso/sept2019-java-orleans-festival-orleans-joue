package com.wildcodeschool.festivalorleansjoue.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.wildcodeschool.festivalorleansjoue.services.ModelService;

@RestController
public class SubscribeEditorModificationController {
	
	@Autowired
	ModelService modelService;
	
	@GetMapping("/subscribeEditorModification")
	public ModelAndView subscribeEditor() {
		
		modelService.setSubscribeEditorModificationModel("subscribeEditorModification",1);
		return modelService.getModel();
	}
}
