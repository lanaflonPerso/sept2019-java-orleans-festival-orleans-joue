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
		
		
//		@PostMapping("/game")
//	    public String getAllByEditor(Model model) {
//
//			
//	    	model.addAttribute("game", gameRepository.findById(id));
//	    	return "game";
//	    }
//		
//		
//		@PostMapping("/game")
//	    public String getAllByRegistrationId(Model model) {
//
//			
//	    	model.addAttribute("game", gameRepository.findById(id));
//	    	return "game";
//	    }
//		
		
		@PostMapping("/addgame")
	    public String postGame(@ModelAttribute Game game) {

	    	

	        return "redirect:/subscribeEditorModification";
	    }
		
		
		@PostMapping("/deletegame")
	    public String deleteGame(@ModelAttribute Game game) {

	    	

	        return "redirect:/subscribeEditorModification";
	    }

}