package com.wildcodeschool.festivalorleansjoue.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.wildcodeschool.festivalorleansjoue.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long>{

	@Query("select u from Event e where e.eventEndingDate > ?1")
	Event findByDate(Date today);
}