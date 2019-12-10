package com.wildcodeschool.festivalorleansjoue.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
			Event e = eventRepository.getOne(Long.parseLong(eventId));
			registration.setEvent(e);
			System.out.println(registration.getEvent().getId());
			Registration registrationEntity = registrationRepository.save(registration);			
			return new ModelAndView("redirect:/accueil_editeur");
		}
}
