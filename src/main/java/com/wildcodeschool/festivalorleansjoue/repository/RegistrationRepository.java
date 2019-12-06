package com.wildcodeschool.festivalorleansjoue.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wildcodeschool.festivalorleansjoue.entity.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {

}
