package com.oxg.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.oxg.app.data.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	List<com.oxg.app.data.Employee> findByLastName(String lastname);
}
