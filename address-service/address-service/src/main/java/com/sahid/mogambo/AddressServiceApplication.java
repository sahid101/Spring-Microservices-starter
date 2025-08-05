package com.sahid.mogambo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({
        "com.sahid.mogambo.req_res",
        "com.sahid.mogambo.controller",
        "com.sahid.mogambo.service"
})
@EnableJpaRepositories({"com.sahid.mogambo.jpa"})
@EntityScan({"com.sahid.mogambo.entity"})
public class AddressServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressServiceApplication.class, args);
	}

}
