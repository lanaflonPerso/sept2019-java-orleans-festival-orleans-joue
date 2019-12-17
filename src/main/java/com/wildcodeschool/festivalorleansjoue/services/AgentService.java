package com.wildcodeschool.festivalorleansjoue.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wildcodeschool.festivalorleansjoue.entity.Agent;
import com.wildcodeschool.festivalorleansjoue.entity.Registration;
import com.wildcodeschool.festivalorleansjoue.entity.Society;
import com.wildcodeschool.festivalorleansjoue.repository.AgentRepository;

@Service
public class AgentService {

	@Autowired
	AgentRepository agentRepository;
	
	
	public List<Agent> findAgentBySociety (Society society){
		
		return agentRepository.findBySociety(society);
	}
	
	
	public List<Agent> findAgentByRegistration (Registration registration){
		
		return agentRepository.findByRegistrations(registration);
	}
	
	
	public List<Agent> findByRegistrationNotSociety (Society society,Registration registration){
		
		return agentRepository.findBySocietyAndRegistrationsNotOrRegistrationsIsNull(society, registration);
	}
	

	public void addAgent (Agent agent) {
		
		agentRepository.save(agent);
	}
	

	public void deleteAgent (Agent agent) {
		
		agentRepository.delete(agent);
	}
	
	
	
}
