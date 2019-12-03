package com.wildcodeschool.festivalorleansjoue.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wildcodeschool.festivalorleansjoue.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
