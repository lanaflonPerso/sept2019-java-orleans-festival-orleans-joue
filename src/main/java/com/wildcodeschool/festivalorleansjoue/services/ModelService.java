package com.wildcodeschool.festivalorleansjoue.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import com.wildcodeschool.festivalorleansjoue.entity.Event;
import com.wildcodeschool.festivalorleansjoue.entity.User;
import com.wildcodeschool.festivalorleansjoue.repository.EventRepository;
import com.wildcodeschool.festivalorleansjoue.repository.UserRepository;

@Service
public class ModelService {

	@Autowired
	EventRepository eventRepository;
	@Autowired
	UserRepository userRepository;
	ModelAndView model = new ModelAndView();
	@Autowired
	UserService userService;
	@Autowired
	EventService eventService;
	@Autowired
	MessageService messageService;
	
	public ModelService() {

	}
	

	public ModelAndView getModel() {

		return this.model;
	}
	

	public void setModel(ModelAndView model) {

		this.model = model;
	}
	

	public void setHomeModel(String route) {

		Date today = new Date();
		this.model = new ModelAndView(route);
		List<Event> events = new ArrayList<>();
		events = eventService.returnEvent(today);
		User connectedUser = userService.returnUser();
		eventService.setMessage(connectedUser, events, today);

		this.model.addObject("connectedUser", connectedUser);
		this.model.addObject("eventError", messageService.eventMessage(events));
		this.model.addObject("event", events);		
	}
	
	
	public void setSubscribeEditorModel(String route) {
		
		this.model = new ModelAndView(route);
		this.model.addObject("connectedUser", userService.returnUser());
		
	}
}
