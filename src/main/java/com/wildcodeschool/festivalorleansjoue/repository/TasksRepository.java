package com.wildcodeschool.festivalorleansjoue.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wildcodeschool.festivalorleansjoue.entity.Tasks;

public interface TasksRepository extends JpaRepository<Tasks, Long>{

}
