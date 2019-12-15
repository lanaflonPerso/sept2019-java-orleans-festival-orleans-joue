package com.wildcodeschool.festivalorleansjoue.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import com.wildcodeschool.festivalorleansjoue.entity.Event;
import com.wildcodeschool.festivalorleansjoue.entity.Registration;
import com.wildcodeschool.festivalorleansjoue.entity.Society;
import com.wildcodeschool.festivalorleansjoue.entity.User;
import com.wildcodeschool.festivalorleansjoue.models.EventCardModel;
import com.wildcodeschool.festivalorleansjoue.repository.EventRepository;
import com.wildcodeschool.festivalorleansjoue.repository.RegistrationRepository;
import com.wildcodeschool.festivalorleansjoue.repository.UserRepository;

@Service
public class ModelService {

	@Autowired
	EventRepository eventRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	RegistrationRepository registrationRepository;
	ModelAndView model = new ModelAndView();
	@Autowired
	UserService userService;
	@Autowired
	EventService eventService;
	@Autowired
	MessageService messageService;
	@Autowired
	NavbarLinksService navbarLinks;
	@Autowired
	GameService gameService;
	@Autowired
	AgentService agentService;

	public ModelService() {

	}
	

	public ModelAndView getModel() {

		return this.model;
	}
	

	public void setModel(ModelAndView model) {

		this.model = model;
	}
	

	public void setHomeModel(String route, Optional<String> hasSubscribe) {

		Date today = new Date();
		this.model = new ModelAndView(route);
		List<Event> events = new ArrayList<>();
		events = eventService.returnEvent(today);
		User connectedUser = userService.returnUser();
		eventService.setMessage(connectedUser, events, today);
		navbarLinks.setCurrentPage("home");
		if (!hasSubscribe.isEmpty()) {
			this.model.addObject("hasSubscribe", (hasSubscribe.get()));
		}
		Society userSociety = connectedUser.getSociety();
		List<EventCardModel> eventCardModels = new ArrayList<>();
		if (userSociety != null) {
			List<Registration> registrationList = userSociety.getRegList();
			this.model.addObject("registrations", registrationList);
			if (registrationList.size() != 0) {
				for (int i = 0; i < events.size(); i++) {
					for (int j = 0; j < registrationList.size(); j++) {
						if (registrationList.get(j).getEvent() == events.get(i)) {
							eventCardModels.add(new EventCardModel(events.get(i), false, true));
						} else {
							eventCardModels.add(new EventCardModel(events.get(i), true, false));	
						}
					}
				}				
			} else {
				for (int i = 0; i < events.size(); i++) {
					eventCardModels.add(new EventCardModel(events.get(i), true, false));
				}
			}
		} else {
			for (int i = 0; i < events.size(); i++) {
				eventCardModels.add(new EventCardModel(events.get(i), true, false));
			}
		}
		this.model.addObject("connectedUser", connectedUser);
		this.model.addObject("eventError", messageService.eventMessage(events));
		this.model.addObject("event", eventCardModels);
		this.model.addObject("navbarLinks", navbarLinks);
	}

	public void setSubscribeEditorModel(String route, int id) {

		Event event = eventRepository.getOne((long) id);
		this.model = new ModelAndView(route);
		this.navbarLinks.setCurrentPage("subscribeEditor");
		this.model.addObject("event", event);
		this.model.addObject("connectedUser", userService.returnUser());
		this.model.addObject("navbarLinks", navbarLinks);
	}

	public void setSubscribeEditorModificationModel(String route, Long registrationId) {

		this.model = new ModelAndView(route);
		System.out.println(registrationId);
		Optional<Registration> optionalReg = registrationRepository.findById(registrationId);
		User connectedUser = userService.returnUser();
		this.navbarLinks.setCurrentPage("subscribeEditorModification");
		if (!optionalReg.isEmpty()) {
			Registration registration = optionalReg.get();
			this.model.addObject("registration", registration);
			this.model.addObject("gamesRegistration", gameService.findByRegistration(registration));
			this.model.addObject("agentRegistration", agentService.findAgentByRegistration(registration));
		}
		this.model.addObject("navbarLinks", navbarLinks);
		this.model.addObject("connectedUser", connectedUser);
		this.model.addObject("society", connectedUser.getSociety());
		this.model.addObject("games", gameService.ReturnGamesBySociety(connectedUser.getSociety()));
		this.model.addObject("agents", agentService.findAgentBySociety(connectedUser.getSociety()));
	}
}
