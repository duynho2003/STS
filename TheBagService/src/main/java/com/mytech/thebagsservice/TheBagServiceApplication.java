package com.mytech.thebagsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.mytech.thebagsservice"})
public class TheBagServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheBagServiceApplication.class, args);
	}

}
