package com.oxg.app.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oxg.app.data.Employee;
import com.oxg.app.repository.EmployeeRepository;


@RestController
public class EmployeeController {
	
	private EmployeeRepository repository;

	public EmployeeController(EmployeeRepository repository) {
		super();
		this.repository = repository;
	}
	
	
	@GetMapping("/employees")
	@CrossOrigin(origins ="http://localhost:4200")
	public Collection<Employee> getAllEmployees() {
		repository.findByLastName("JohN");
		return repository.findAll()
				.stream()
				.collect(Collectors.toList());
	}
	
}
