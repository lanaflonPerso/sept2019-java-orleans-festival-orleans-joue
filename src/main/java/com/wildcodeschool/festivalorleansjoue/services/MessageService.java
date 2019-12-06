package com.wildcodeschool.festivalorleansjoue.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wildcodeschool.festivalorleansjoue.entity.Event;

@Repository
public class MessageService implements IMessageService{

	@Autowired
	ErrorMsgModel errorMsgModel;
	@Override
	public ErrorMsgModel eventMessage(List<Event> events) {

		if (events.size() == 0) {
			errorMsgModel.setErrorON(true);
			errorMsgModel.setErrorMsg("Aucun évènnement en cours.");
		}
		return errorMsgModel;
	};

}
