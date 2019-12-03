package com.wildcodeschool.festivalorleansjoue.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wildcodeschool.festivalorleansjoue.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long>{

	Event findByEventEndingDateAfter(Date today);
}