package com.wildcodeschool.festivalorleansjoue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wildcodeschool.festivalorleansjoue.entity.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long>{

}
