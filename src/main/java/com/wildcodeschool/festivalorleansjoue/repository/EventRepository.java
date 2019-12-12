package com.wildcodeschool.festivalorleansjoue.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wildcodeschool.festivalorleansjoue.entity.Event;
import com.wildcodeschool.festivalorleansjoue.entity.Registration;

@Repository
public interface EventRepository extends JpaRepository<Event, Long>{

	public List<Event> findByEventEndingDateAfter(Date today);
	public Event findByRegList(Registration registration);
	
}