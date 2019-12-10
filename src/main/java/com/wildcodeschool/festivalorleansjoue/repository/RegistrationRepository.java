package com.wildcodeschool.festivalorleansjoue.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.wildcodeschool.festivalorleansjoue.entity.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {

	public List<Registration> findByState(String state);
	
	@Query(value ="SELECT * from registration JOIN society_referent ON society_referent.id=registration.society_id "
			+ "JOIN user ON user.id=society_referent.user_id WHERE user.id=?1", nativeQuery = true)
	public List<Registration> findByUserId(Long userId);
}
