package com.danisample.springdatajpasample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class SpringDataJpaSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaSampleApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository customerRepository) {
		return (args -> {
			// Save customers
			customerRepository.save(new Customer("Juan", "García"));
			customerRepository.save(new Customer("René", "Irusta"));
			customerRepository.save(new Customer("Aldo", "Poy"));
			customerRepository.save(new Customer("Jose", "Arenado"));
			customerRepository.save(new Customer("Carlos", "Irusta"));

			// Fetch all customers
			log.info("---------------------------------");
			log.info("Fetching all customers:");
			customerRepository.findAll().forEach(System.out::println);

			// Fetch by ID
			log.info("---------------------------------");
			long id = 1L;
			log.info("Fetching by ID: " + id);
			log.info(customerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id not found")).toString());

			// Fetch by Last Name
			log.info("---------------------------------");
			String lastName = "Irusta";
			log.info("Fetching by last name: " + lastName);
			customerRepository.findByLastName(lastName).stream().forEach(System.out::println);

		});
	}
}
