package com.wildcodeschool.festivalorleansjoue.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.wildcodeschool.festivalorleansjoue.entity.Game;
import com.wildcodeschool.festivalorleansjoue.entity.Registration;
import com.wildcodeschool.festivalorleansjoue.entity.Society;
import com.wildcodeschool.festivalorleansjoue.repository.GameRepository;

@Service
public class GameService {

	@Autowired
	GameRepository gameRepository;
	
	@Autowired
	private FileService fileService;
	
	public List<Game> ReturnGamesBySociety (Society society){
		
		return gameRepository.findBySociety(society);
	}
	
	
	public List<Game> findByRegistration (Registration registration){
		
		return gameRepository.findByRegistrations(registration);
	}
	
	public List<Game> findByRegistrationNotSociety (Society society,Registration registration){
		
		return gameRepository.findBySocietyAndRegistrationsNotOrRegistrationsIsNull(society, registration);
	}
	
	public void addGame (Game game) {
				
		gameRepository.save(game);
	}
	

	public void deleteGame (Game game) {
		
		gameRepository.delete(game);
	}

	
	public void modifyGame (Game game, Optional<MultipartFile> picture) {
		
		Optional<Game> originalGame = gameRepository.findById(game.getId());
		if(game.getAuthor()!="")
			originalGame.get().setAuthor(game.getAuthor());
		if(game.getDescription()!="")
			originalGame.get().setDescription(game.getDescription());
		if(game.getName()!="")
			originalGame.get().setName(game.getName());
		System.out.println(game.getPicture().equals(""));
		if(!game.getPicture().equals("")) {
			System.out.println("picture n'est pas egal a vide");
			originalGame.get().setPicture("/pictures/uploads/games_pictures/" + fileService.uploadFile(picture.get()));
		}
		System.out.println(originalGame.get().getPicture());
		if(game.getPublicationDate()!=null)
			originalGame.get().setPublicationDate(game.getPublicationDate());
		game.setSociety(originalGame.get().getSociety());
		gameRepository.save(originalGame.get());
	}
}
