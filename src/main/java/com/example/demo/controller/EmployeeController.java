package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeRepository;

@RestController
public class EmployeeController {

	private Logger log = LoggerFactory.getLogger(EmployeeController.class);

	private EmployeeRepository repository;

	public EmployeeController(EmployeeRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/employees")
	List<Employee> all() {
		log.info("all employees]");
		
		return repository.findAll();
	}

	@GetMapping("/employees/{id}")
	Employee one(@PathVariable Long id) throws EmployeeNotFoundException {
		log.info("get employee [id= " + id +"]");
		
		return repository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException(id));
	}
	
	@PostMapping("/employees")
	Employee newEmployee(@RequestBody Employee newEmployee) {
		log.info("employee recorded");
		
		return repository.save(newEmployee);
	}

	@PutMapping("/employees/{id}")
	Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
		log.info("employee replaced [id= " + id +"]");
		
		return repository.findById(id).map(employee -> {
			employee.setName(newEmployee.getName());
			employee.setRole(newEmployee.getRole());
			return repository.save(employee);
		}).orElseGet(() -> {
			newEmployee.setId(id);
			return repository.save(newEmployee);
		});
	}

	@DeleteMapping("/employees/{id}")
	void deleteEmployee(@PathVariable Long id) {
		repository.deleteById(id);
		
		log.info("employee deleted [id= " + id +"]");
	}

}
