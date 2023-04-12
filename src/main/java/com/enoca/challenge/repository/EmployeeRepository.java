package com.enoca.challenge.repository;

import com.enoca.challenge.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<List<Employee>> findAllByFirstNameIgnoreCase(String firstName);
}
