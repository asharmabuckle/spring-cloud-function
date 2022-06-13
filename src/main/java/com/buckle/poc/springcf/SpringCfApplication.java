package com.buckle.poc.springcf;

import com.buckle.poc.springcf.packagedfunc.JDBCasSupplier;
import com.buckle.poc.springcf.packagedfunc.JPAasSupplier;
import com.buckle.poc.springcf.packagedfunc.ReverseString;
import com.buckle.poc.springcf.packagedfunc.UpperCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class SpringCfApplication {

	@Autowired
	UpperCase upperCase;
	@Autowired
	ReverseString reverseString;

	@Autowired
	JPAasSupplier jpAasSupplier;

	@Autowired
	JDBCasSupplier jdbCasSupplier;

	public static void main(String[] args) {
		SpringApplication.run(SpringCfApplication.class, args);
	}

	@Bean
	Function<String, String> compositeFunction() {
		return value -> upperCase.compose(reverseString).apply(value);
	}
}
