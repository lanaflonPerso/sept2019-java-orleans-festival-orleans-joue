package com.wildcodeschool.festivalorleansjoue.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.wildcodeschool.festivalorleansjoue.entity.ErrorMsgModel;
import com.wildcodeschool.festivalorleansjoue.entity.Event;
import com.wildcodeschool.festivalorleansjoue.entity.User;
import com.wildcodeschool.festivalorleansjoue.repository.EventRepository;
import com.wildcodeschool.festivalorleansjoue.repository.UserRepository;

@RestController
public class HomeExposantController {	
	
	@Autowired 
	EventRepository eventRepository;
	@Autowired
	UserRepository userRepository;
	ErrorMsgModel noEvent;
	ModelAndView model = new ModelAndView();
	
	@GetMapping("/accueil_editeur") 
	public ModelAndView homeEditor() {
		setModel("homeEditor");
		return this.model;	
	}

	@GetMapping("/accueil_boutique") 
	public ModelAndView homeshop() {
		setModel("homeShop");
		return this.model;	
	}
	
	@GetMapping("/accueil_volontaires") 
	public ModelAndView homeVolunteers() {
		setModel("homeVolunteers");
		return this.model;	
	}

	public void setModel (String route) {
		Date today = new Date();
		List<Event> events = new ArrayList<>();
		events = eventRepository.findByEventEndingDateAfter(today);
		model = new ModelAndView(route);
		if (events.size() > 0) {
			noEvent = new ErrorMsgModel();
			model.addObject("event", events);
			model.addObject("eventError", noEvent);
		} else {
			noEvent = new ErrorMsgModel("Aucun évènnement en cours");
			model.addObject("eventError", noEvent);
		}
		
		User connectedUser= new User();
		Optional<User> optionalUser = userRepository.findById(1L);		
		if (optionalUser.isPresent()) {
			connectedUser = optionalUser.get();
        }
		model.addObject("connectedUser", connectedUser);
		
	}
}