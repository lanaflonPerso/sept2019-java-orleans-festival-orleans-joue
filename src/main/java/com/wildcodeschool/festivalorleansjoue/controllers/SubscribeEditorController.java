package com.wildcodeschool.festivalorleansjoue.controllers;

import java.util.Date;
import java.util.Optional;

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
import com.wildcodeschool.festivalorleansjoue.entity.User;
import com.wildcodeschool.festivalorleansjoue.repository.EventRepository;
import com.wildcodeschool.festivalorleansjoue.repository.RegistrationRepository;
import com.wildcodeschool.festivalorleansjoue.repository.UserRepository;
import com.wildcodeschool.festivalorleansjoue.services.ModelService;
import com.wildcodeschool.festivalorleansjoue.utils.MathUtils;


	@RestController
	public class SubscribeEditorController {
		
		@Autowired
		ModelService modelService;		
		@Autowired
		RegistrationRepository registrationRepository;		
		@Autowired
		EventRepository eventRepository;
		@Autowired
		UserRepository userRepository;
		
		@PostMapping("/subscribeEditor")
		public ModelAndView subscribeEditor(@RequestParam int id) {
			
			modelService.setSubscribeEditorModel("subscribeEditor",id);
			return modelService.getModel();
		}
		
		
		@PostMapping("/submitRegistration")
		public ModelAndView submitRegistration(@ModelAttribute Registration registration, @RequestParam Long userId, @RequestParam String eventId) {
			Date subscriptionDate = new Date();
			registration.setSubscriptionDate(subscriptionDate);
			
			Event event = eventRepository.getOne(Long.parseLong(eventId));
			registration.setEvent(event);
			
			if (registration.getTablesQuantity() > event.getMaxTablesPerEditor()) {
				registration.setTablesQuantity(event.getMaxTablesPerEditor());
			}
			if (registration.getTablesQuantity() < 0) {
				registration.setTablesQuantity(0);
			}
			int tablesQuantity = registration.getTablesQuantity();
			float tablePrice = event.getPricePerTable();		
			float saleOptionPrice = (registration.isSaleOption()) ? event.getSaleOptionPrice() : 0.00f;
			float registrationCost = MathUtils.registrationCost(tablesQuantity, tablePrice, saleOptionPrice);
			registration.setRegistrationCost(registrationCost);
			if (registration.getTablesQuantity() > event.getMaxTablesPerEditor()) {
				registration.setTablesQuantity(event.getMaxTablesPerEditor());
			}
			Optional<User> optionalUser = userRepository.findById(userId);
			User user = null;
			if (!optionalUser.isEmpty()) {
				user = optionalUser.get();
			}
			registration.setSociety(user.getSociety());
			registration.setState("pending");
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
