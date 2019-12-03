package com.wildcodeschool.festivalorleansjoue.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.wildcodeschool.festivalorleansjoue.entity.ErrorMsgModel;
import com.wildcodeschool.festivalorleansjoue.entity.Event;
import com.wildcodeschool.festivalorleansjoue.repository.EventRepository;

@RestController
public class HomeExposantController {	
	
	@Autowired 
	EventRepository eventRepository;
	ErrorMsgModel noEvent;
	
	@GetMapping("/accueil_exposant") 
	public ModelAndView homeExposant(ModelAndView model) {
		
		Date today = new Date();
		List<Event> event = new ArrayList<>();
		event = eventRepository.findByEventEndingDateAfter(today);
		model = new ModelAndView("accueil_exposants");
		if (event.size() > 0) {
			model.addObject("event", event);	
			return model;
		} else {
			noEvent = new ErrorMsgModel("Aucun évènnement en cours");
			model.addObject("noEvent", noEvent);
			return model;
		}
	}
}
