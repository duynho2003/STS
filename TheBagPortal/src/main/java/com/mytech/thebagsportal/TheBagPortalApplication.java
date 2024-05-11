package com.mytech.thebagsportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.mytech.thebagsservice", "com.mytech.thebagsportal"})
@EntityScan({"com.mytech.thebagsservice"})
public class TheBagPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheBagPortalApplication.class, args);
	}

}
