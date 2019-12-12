package com.wildcodeschool.festivalorleansjoue.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wildcodeschool.festivalorleansjoue.entity.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {

	public List<Registration> findByState(String state);
}
