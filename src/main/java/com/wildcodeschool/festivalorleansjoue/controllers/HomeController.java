package com.wildcodeschool.festivalorleansjoue.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.wildcodeschool.festivalorleansjoue.entity.Event;
import com.wildcodeschool.festivalorleansjoue.repository.EventRepository;

@RestController
public class HomeController {	
	
	@Autowired 
	EventRepository eventRepository;
	
	@GetMapping("/") 
	public ModelAndView home(ModelAndView model) {
		
		Date today = new Date();
		Event event = eventRepository.findByEventEndingDateAfter(today);
		model = new ModelAndView("home");
		if(event != null) {
			model.addObject(event);
		}
		return model;
	}
}
