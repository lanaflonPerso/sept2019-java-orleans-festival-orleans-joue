package com.wildcodeschool.festivalorleansjoue.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.wildcodeschool.festivalorleansjoue.services.ModelService;

@RestController
public class SubscribeEditorModificationController {
	
	@Autowired
	ModelService modelService;
	
	
	@RequestMapping(value = "/subscribeEditorModification", method = { RequestMethod.GET, RequestMethod.POST })
		public ModelAndView subscribeEditor(@RequestParam Long registrationId) {
		
		modelService.setSubscribeEditorModificationModel("subscribeEditorModification",registrationId);
		return modelService.getModel();
	}
}
