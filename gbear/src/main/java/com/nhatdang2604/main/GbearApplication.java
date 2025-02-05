package com.nhatdang2604.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.nhatdang2604")
public class GbearApplication {

	public static void main(String[] args) {
		SpringApplication.run(GbearApplication.class, args);
	}

}
