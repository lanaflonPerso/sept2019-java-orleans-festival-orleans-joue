package com.wildcodeschool.festivalorleansjoue.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wildcodeschool.festivalorleansjoue.entity.Agent;
import com.wildcodeschool.festivalorleansjoue.entity.Registration;
import com.wildcodeschool.festivalorleansjoue.entity.Society;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long>{

	public List<Agent> findBySociety (Society society);
	
	public List<Agent> findByRegistrations (Registration registration);

	public List<Agent> findBySocietyAndRegistrationsNotOrRegistrationsIsNull (Society society, Registration registration);
}
