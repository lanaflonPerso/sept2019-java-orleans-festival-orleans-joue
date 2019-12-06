package com.wildcodeschool.festivalorleansjoue.services;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wildcodeschool.festivalorleansjoue.entity.Event;

@Repository
public class MessageService implements IMessageService{

	@Override
	public ErrorMsgModel eventMessage(List<Event> events) {

		ErrorMsgModel errorModel = new ErrorMsgModel();
		
		if (events.size() == 0) {
			errorModel.setErrorON(true);
			errorModel.setErrorMsg("Aucun évènnement en cours.");
		}
		return errorModel;
	};

}
