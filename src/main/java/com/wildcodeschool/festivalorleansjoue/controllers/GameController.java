package com.wildcodeschool.festivalorleansjoue.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.wildcodeschool.festivalorleansjoue.entity.Game;
import com.wildcodeschool.festivalorleansjoue.repository.GameRepository;
import com.wildcodeschool.festivalorleansjoue.repository.SocietyRepository;
import com.wildcodeschool.festivalorleansjoue.services.FileService;
import com.wildcodeschool.festivalorleansjoue.services.GameService;
import com.wildcodeschool.festivalorleansjoue.services.RegistrationService;
import com.wildcodeschool.festivalorleansjoue.services.UserService;

	@Controller
	public class GameController {

		@Autowired
		private GameRepository gameRepository;		
		@Autowired
		private GameService gameService;		
		@Autowired
		private RegistrationService registrationService;		
		@Autowired
		private FileService fileService;	
		@Autowired
		private SocietyRepository societyRepository;
		@Autowired
		private UserService userService;
		
		
		@PostMapping("/game")
	    public String getAll(Model model) {

	    	model.addAttribute("game", gameRepository.findAll());
	    	return "game";
	    }
		

		@PostMapping("/addGame")
	    public ModelAndView postGame(@ModelAttribute Game game) {
			
			gameService.addGame(game);
			ModelMap model = new ModelMap();
			model.addAttribute("Game", game);
			return new ModelAndView("redirect:/profil", model);
		}
		
		
		@PostMapping("/addRegistrationGame")
	    public ModelAndView postRegistrationGame(@ModelAttribute Game game, @RequestParam(name = "file_picture") MultipartFile filePicture, Long registrationId, Long societyId) {
			
			if (!filePicture.isEmpty())
				game.setPicture("/pictures/uploads/games_pictures/" + fileService.uploadFile(filePicture));
			game.setSociety(societyRepository.getOne(societyId));
			gameService.addGame(game);
			registrationService.addRegistrationGame(game, registrationId);
			ModelMap model = new ModelMap();
			model.addAttribute("registrationId", registrationId);
			return new ModelAndView("redirect:/subscribeEditorModification", model);
	    }
		
		
		@PostMapping("/deleteRegistrationGame")
	    public ModelAndView deleteGame(@RequestParam Long gameRegistrationId, Long registrationId) {
			
			Game game = gameRepository.getOne(gameRegistrationId);
			registrationService.deleteRegistrationGame(game, registrationId);
			ModelMap model = new ModelMap();
			model.addAttribute("registrationId", registrationId);
			return new ModelAndView("redirect:/subscribeEditorModification", model);
	    }
		
		@PostMapping("/modifyGame")
	    public ModelAndView modifyGame(@ModelAttribute Game game, Long registrationId,@RequestParam(required = false) Optional<MultipartFile> picture) {
			gameService.modifyGame(game, picture);
			ModelMap model = new ModelMap();
			model.addAttribute("registrationId", registrationId);
			return new ModelAndView("redirect:/subscribeEditorModification", model);
		}

}