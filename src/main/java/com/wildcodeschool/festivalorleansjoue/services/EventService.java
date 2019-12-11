package com.wildcodeschool.festivalorleansjoue.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.Date;
import com.wildcodeschool.festivalorleansjoue.entity.Event;
import com.wildcodeschool.festivalorleansjoue.entity.User;
import com.wildcodeschool.festivalorleansjoue.repository.EventRepository;
import com.wildcodeschool.festivalorleansjoue.utils.DateUtils;

@Repository
public class EventService implements IEventService{

	@Autowired
	EventRepository eventRepository;
	
	@Override
	public List<Event> returnEvent(Date today){

		List<Event> events = new ArrayList<>();
		events = eventRepository.findByEventEndingDateAfter(today);
		return events;
	}

	@Override
	public void setMessage(User user, List<Event> events, Date today) {
		if (user.getUserRole().getWording().equals("editeur")) {
			for (Event event2 : events) {
				if (event2.getEditorsRegistrationBeginDate().before(today) && event2.getEditorsRegistrationEndDate().after(today)) {
					event2.setRegistrationOpen(true);
				} else
					DateUtils.registrationCondition(today, event2);
			}
		}

		else if (user.getUserRole().getWording().equals("boutique")) {
			for (Event event2 : events) {
				if (event2.getShopsRegistrationBeginDate().before(today) && event2.getShopsRegistrationEndDate().after(today)) {
					event2.setRegistrationOpen(true);
				} else
					DateUtils.registrationCondition(today, event2);
			}
		}

		else if (user.getUserRole().getWording().equals("benevole")) {
			for (Event event2 : events) {
				if (event2.getVolunteersRegistrationBeginDate().before(today) && event2.getVolunteersRegistrationEndDate().after(today)) {
					event2.setRegistrationOpen(true);
				} else
					DateUtils.registrationCondition(today, event2);
			}
		}
	}
}
