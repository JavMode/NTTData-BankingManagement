package com.nttdata.microservice_credit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceCreditApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceCreditApplication.class, args);
	}

}
