package com.barkeeper.barkeeperserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class BarkeeperServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarkeeperServerApplication.class, args);
	}

}
