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
import com.wildcodeschool.festivalorleansjoue.utils.DateUtils;

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
	

	public void setHomeModel(String route) {

		Date today = new Date();
		List<Event> events = new ArrayList<>();
		events = eventRepository.findByEventEndingDateAfter(today);
		this.errorModel = new ErrorMsgModel();
		this.model = new ModelAndView(route);		
		if (events.size() == 0) {
			this.errorModel.setErrorON(true);
			this.errorModel.setErrorMsg("Aucun évènnement en cours.");
		}

		User connectedUser = new User();
		Optional<User> optionalUser = userRepository.findById(1L);
		if (optionalUser.isPresent()) {
			connectedUser = optionalUser.get();
		}

		if (connectedUser.getUserRole().getWording().equals("editeur")) {
			for (Event event2 : events) {
				if (event2.getEditorsRegistrationBeginDate().before(today) && event2.getEditorsRegistrationEndDate().after(today)) {
					event2.setRegistrationOpen(true);
				} else
					DateUtils.registrationCondition(today, event2);
			}
		}

		else if (connectedUser.getUserRole().getWording().equals("boutique")) {
			for (Event event2 : events) {
				if (event2.getShopsRegistrationBeginDate().before(today) && event2.getShopsRegistrationEndDate().after(today)) {
					event2.setRegistrationOpen(true);
				} else
					DateUtils.registrationCondition(today, event2);
			}
		}

		else if (connectedUser.getUserRole().getWording().equals("benevole")) {
			for (Event event2 : events) {
				if (event2.getVolunteersRegistrationBeginDate().before(today) && event2.getVolunteersRegistrationEndDate().after(today)) {
					event2.setRegistrationOpen(true);
				} else
					DateUtils.registrationCondition(today, event2);
			}
		}

		this.model.addObject("connectedUser", connectedUser);
		this.model.addObject("eventError", this.errorModel);
		this.model.addObject("event", events);		
	}
	
	
	public void setSubscribeEditorModel(String route) {
		
		User connectedUser = new User();
		Optional<User> optionalUser = userRepository.findById(1L);
		if (optionalUser.isPresent()) {
			connectedUser = optionalUser.get();
		}
		this.model = new ModelAndView(route);
		this.model.addObject("connectedUser", connectedUser);
		
	}
}
