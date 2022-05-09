package com.github.sumitdas28.restservicesapp.config;

import com.github.sumitdas28.restservicesapp.model.Employee;
import com.github.sumitdas28.restservicesapp.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadH2Database {
    private static final Logger log = LoggerFactory.getLogger(LoadH2Database.class);

    @Bean
    public CommandLineRunner initializeDatabase(EmployeeRepository employeeRepository){
        return args -> {
            // Loading Employee Repository
            log.info("Preloading..." + employeeRepository.save(new Employee("Sam","Developer")));
            log.info("Preloading..." + employeeRepository.save(new Employee("John","Tester")));
            log.info("Preloading..." + employeeRepository.save(new Employee("Tina","Architect")));
            log.info("Preloading..." + employeeRepository.save(new Employee("Johnny","Manager")));
            log.info("Preloading..." + employeeRepository.save(new Employee("Maria","Business Analyst")));
        };
    }
}
