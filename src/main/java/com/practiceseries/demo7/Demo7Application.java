package com.practiceseries.demo7;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.practiceseries.demo7")
@EnableJpaRepositories
public class Demo7Application {
	public static void main(String[] args) {
		SpringApplication.run(Demo7Application.class, args);

	}
  @Bean
	public ModelMapper modelMapper()
  {
		return new ModelMapper();
	}
}
