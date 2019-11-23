package com.mutants.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

public class MutantsApplicationComponentScan {
	
	@ComponentScan(basePackages = {"com", "com.mutants.repositories", "com.mutants.services"})
	@Configuration
	public class ApplicationComponentScan {
	}

}
