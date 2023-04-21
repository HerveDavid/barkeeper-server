package com.barkeeper.barkeeperserver.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.barkeeper.barkeeperserver.repository")
public class PersistenceJPAConfiguration {
}
