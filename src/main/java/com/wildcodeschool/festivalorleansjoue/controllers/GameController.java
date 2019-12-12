package com.wildcodeschool.festivalorleansjoue.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.wildcodeschool.festivalorleansjoue.entity.Game;
import com.wildcodeschool.festivalorleansjoue.repository.GameRepository;

	@Controller
	public class GameController {

		@Autowired
		private GameRepository gameRepository;
		
		
		
		@PostMapping("/game")
	    public String getAll(Model model) {

	    	model.addAttribute("game", gameRepository.findAll());
	    	return "game";
	    }
		
		
		
		
		@PostMapping("/addgame")
	    public String postGame(@ModelAttribute Game game) {

	    	gameRepository.save(game);

	        return "redirect:/subscribeEditorModification";
	    }
		
		
		@PostMapping("/deletegame")
	    public String deleteGame(@ModelAttribute Game game) {

	    	gameRepository.deleteById(game.getId());

	        return "redirect:/subscribeEditorModification";
	    }
		
		
		//getAllByEditor
		
		//getAllByRegistrationId
		

		
}