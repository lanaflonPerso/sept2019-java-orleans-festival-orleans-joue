package com.wildcodeschool.festivalorleansjoue.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wildcodeschool.festivalorleansjoue.entity.Game;
import com.wildcodeschool.festivalorleansjoue.entity.Registration;
import com.wildcodeschool.festivalorleansjoue.entity.Society;
import com.wildcodeschool.festivalorleansjoue.repository.GameRepository;

@Service
public class GameService {

	@Autowired
	GameRepository gameRepository;
	
	
	public List<Game> ReturnGamesBySociety (Society society){
		
		return gameRepository.findBySociety(society);
	}
	
	
	public List<Game> findByRegistration (Registration registration){
		
		return gameRepository.findByRegistrations(registration);
	}
	

	public void addGame (Game game) {
		
		gameRepository.save(game);
	}
	

	public void deleteGame (Game game) {
		
		gameRepository.delete(game);
	}
	
	
	
}
