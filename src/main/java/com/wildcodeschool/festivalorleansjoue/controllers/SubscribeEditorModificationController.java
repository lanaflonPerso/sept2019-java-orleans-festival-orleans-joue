package com.wildcodeschool.festivalorleansjoue.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.wildcodeschool.festivalorleansjoue.services.ModelService;

@Controller
public class SubscribeEditorModificationController {

	@Autowired
	ModelService modelService;

	@RequestMapping(value = "/subscribeEditorModification", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView subscribeEditorUpdate(@RequestParam Long registrationId, @RequestParam (name="hasSubscribe", required = false) Optional<String> hasSubscribe) {

		modelService.setSubscribeEditorModificationModel("subscribeEditorModification", registrationId, hasSubscribe);
		return modelService.getModel();
	}
}
