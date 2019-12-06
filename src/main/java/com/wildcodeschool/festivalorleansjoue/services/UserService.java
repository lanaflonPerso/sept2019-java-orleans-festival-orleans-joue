package com.wildcodeschool.festivalorleansjoue.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wildcodeschool.festivalorleansjoue.entity.User;
import com.wildcodeschool.festivalorleansjoue.repository.UserRepository;




@Repository
public class UserService implements IUserService{

	@Autowired
	UserRepository userRepository;
	
	public User returnUser() {
		User connectedUser = new User();
		Optional<User> optionalUser = userRepository.findById(1L);
		if (optionalUser.isPresent()) {
			connectedUser = optionalUser.get();
		}
		
		return connectedUser;
	}
}
