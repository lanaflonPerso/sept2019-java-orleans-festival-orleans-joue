package com.wildcodeschool.festivalorleansjoue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wildcodeschool.festivalorleansjoue.entity.Tasks;

@Repository
public interface TasksRepository extends JpaRepository<Tasks, Long>{

}
