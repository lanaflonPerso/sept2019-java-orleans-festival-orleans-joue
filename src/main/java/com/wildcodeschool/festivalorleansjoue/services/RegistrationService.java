package com.wildcodeschool.festivalorleansjoue.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wildcodeschool.festivalorleansjoue.entity.Game;
import com.wildcodeschool.festivalorleansjoue.entity.Registration;
import com.wildcodeschool.festivalorleansjoue.repository.GameRepository;
import com.wildcodeschool.festivalorleansjoue.repository.RegistrationRepository;

@Service
public class RegistrationService {

	@Autowired
	RegistrationRepository registrationRepository;
	
	@Autowired
	GameRepository gameRepository;
	
	public void addRegistrationGame(Game game, Long registrationId) {
		
//		Registration registration = registrationRepository.findById(registrationId).get();
//		registration.getGames().add(game);
//		registrationRepository.save(registration);
		
		Game games = gameRepository.save(game);
		games.getRegistrations().add(registrationRepository.findById(registrationId).get());
		gameRepository.save(game);
	}
	
	
	public void deleteRegistrationGame(Game game, Long registrationId) {
		
		Registration registration = registrationRepository.findById(registrationId).get();
		registration.getGames().remove(game);
		System.out.println(registration.getGames().size());
		registrationRepository.save(registration);
		registration = registrationRepository.findById(registrationId).get();
		System.out.println(registration.getGames().size());
	}
	
}
