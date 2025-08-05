package com.sahid.mogambo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@ComponentScan({
		"com.sahid.mogambo.controller",
		"com.sahid.mogambo.service"
})
@EntityScan({
		"com.sahid.mogambo.entity"
})
@EnableJpaRepositories({
		"com.sahid.mogambo.jpa"
})
@EnableFeignClients({
		"com.sahid.mogambo.feignclients"
})
public class StudentServiceApplication {

	@Value("${address.service.url}")
	private String adddresBaseUrl;

	public static void main(String[] args) {
		SpringApplication.run(StudentServiceApplication.class, args);
	}

	@Bean
	public WebClient createWebClient(){
        return WebClient.builder()
                .baseUrl(adddresBaseUrl)
                .build();
	}
}
