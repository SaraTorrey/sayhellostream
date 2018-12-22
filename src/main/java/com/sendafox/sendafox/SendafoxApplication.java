package com.sayhellostream.sayhellostream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaTransactionManager;

import javax.persistence.EntityManagerFactory;

@SpringBootApplication
public class SendafoxApplication {

	public static void main(String[] args) {
		SpringApplication.run(SendafoxApplication.class, args);
	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}
}

