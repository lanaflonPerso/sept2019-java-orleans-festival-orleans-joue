package com.wildcodeschool.festivalorleansjoue.services;

import java.util.List;

import com.wildcodeschool.festivalorleansjoue.entity.Event;

public interface IMessageService {

	
	public ErrorMsgModel eventMessage(List<Event> event);
}
