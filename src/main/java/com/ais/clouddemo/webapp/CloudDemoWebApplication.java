package com.ais.clouddemo.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.ais.clouddemo.webapp")
public class CloudDemoWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudDemoWebApplication.class, args);
	}
}
