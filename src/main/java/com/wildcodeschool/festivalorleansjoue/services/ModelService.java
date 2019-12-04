package com.wildcodeschool.festivalorleansjoue.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
	ErrorMsgModel errorModel;
	
	public ModelService() {
		
	}
	

	public ModelAndView getModel() {
		
		return this.model;
	}
	

	public void setModel(ModelAndView model) {
		
		this.model = model;
	}
	
	
	public void setEventModel (String route) {
		
		Date today = new Date();
		List<Event> event = new ArrayList<>();
		event = eventRepository.findByEventEndingDateAfter(today);
		this.errorModel = new ErrorMsgModel();
		this.model = new ModelAndView(route);
		if (event.size() == 0) {
			this.errorModel.setErrorON(true);
			this.errorModel.setErrorMsg("Aucun évènnement en cours.");
		}
		User connectedUser= new User();
		Optional<User> optionalUser = userRepository.findById(1L);		
		if (optionalUser.isPresent()) {
			connectedUser = optionalUser.get();
        }
		this.model.addObject("connectedUser", connectedUser);
		this.model.addObject("eventError", this.errorModel);
		this.model.addObject("event", event);		
	}
}

