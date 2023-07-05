package com.eviden.onecloud.repositories;


// spring boot repository using pojo: Employee

import com.eviden.onecloud.models.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {
}
