package com.pocs.testecarga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class TesteCargaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesteCargaApplication.class, args);
	}

}
