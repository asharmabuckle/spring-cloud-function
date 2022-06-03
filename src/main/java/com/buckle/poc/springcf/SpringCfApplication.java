package com.buckle.poc.springcf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@SpringBootApplication
public class SpringCfApplication {

	@Bean
//	public Function<Flux<String>, Flux<String>> uppercase() {
	public Function<String, String> uppercase() {
		return value -> value.toUpperCase();
	}


	@Bean
	public Function<String, String> reversestring() {
		return value -> new StringBuilder(value).reverse().toString();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringCfApplication.class, args);
	}

}
