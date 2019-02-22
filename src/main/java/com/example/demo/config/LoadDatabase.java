package com.example.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
class LoadDatabase {
	
	private  Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner initDatabase(EmployeeRepository repository) {
		return args -> {
			log.info("Preloading " + repository.save(new Employee("Anderson", "master")));
			log.info("Preloading " + repository.save(new Employee("Morpheus", "boss")));
			log.info("Preloading " + repository.save(new Employee("Trinity", "user")));
		};
	}
}
