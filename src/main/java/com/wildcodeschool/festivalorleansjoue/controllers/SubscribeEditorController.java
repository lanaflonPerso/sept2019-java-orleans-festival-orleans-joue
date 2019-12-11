package com.wildcodeschool.festivalorleansjoue.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.wildcodeschool.festivalorleansjoue.entity.Event;
import com.wildcodeschool.festivalorleansjoue.entity.Registration;
import com.wildcodeschool.festivalorleansjoue.repository.EventRepository;
import com.wildcodeschool.festivalorleansjoue.repository.RegistrationRepository;
import com.wildcodeschool.festivalorleansjoue.services.ModelService;


	@RestController
	public class SubscribeEditorController {
		
		@Autowired
		ModelService modelService;
		
		@Autowired
		RegistrationRepository registrationRepository;
		
		@Autowired
		EventRepository eventRepository;
		
		@PostMapping("/subscribeEditor")
		public ModelAndView subscribeEditor(@RequestParam int id) {
			
			modelService.setSubscribeEditorModel("subscribeEditor",id);
			return modelService.getModel();
		}
		
		@PostMapping("/submitRegistration")
		public ModelAndView submitRegistration(@ModelAttribute Registration registration, @RequestParam String eventId) {
			Date subscriptionDate = new Date();
			Event createdEvent = eventRepository.getOne(Long.parseLong(eventId));
			registration.setEvent(createdEvent);
			registration.setSubscriptionDate(subscriptionDate);
			if (registration.getTablesQuantity() > createdEvent.getMaxTablesPerEditor()) {
				registration.setTablesQuantity(createdEvent.getMaxTablesPerEditor());
			}
			registrationRepository.save(registration);
			ModelMap model = new ModelMap();
			model.addAttribute("hasSubscribe", "ok");
			return new ModelAndView("redirect:/accueil_editeur", model);
		}
		
		@GetMapping("/stopRegistration")
		public ModelAndView stopRegistration() {
			
			ModelMap model = new ModelMap();
			model.addAttribute("hasSubscribe", "ko");
			return new ModelAndView("redirect:/accueil_editeur", model);
		}

}
