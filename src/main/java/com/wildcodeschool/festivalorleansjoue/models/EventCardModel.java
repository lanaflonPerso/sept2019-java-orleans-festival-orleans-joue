package com.wildcodeschool.festivalorleansjoue.models;

import com.wildcodeschool.festivalorleansjoue.entity.Event;

public class EventCardModel {
	
	private Event event;
	private boolean subscribeBtnOn = true;
	
	public EventCardModel(Event event, boolean subscribeBtnOn) {
		
		this.event = event;
		this.subscribeBtnOn = subscribeBtnOn;
	}
	

	public Event getEvent() {
		
		return this.event;
	}

	
	public void setEvent(Event event) {
		
		this.event = event;
	}

	
	public boolean isSubscribeBtnOn() {
		
		return this.subscribeBtnOn;
	}

	
	public void setSubscribeBtnOn(boolean subscribeBtnOn) {
		
		this.subscribeBtnOn = subscribeBtnOn;
	}
	

}
