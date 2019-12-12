package com.wildcodeschool.festivalorleansjoue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wildcodeschool.festivalorleansjoue.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
}
