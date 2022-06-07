package com.buckle.poc.springcf;

import com.buckle.poc.springcf.packagedfunc.ReverseString;
import com.buckle.poc.springcf.packagedfunc.UpperCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class SpringCfApplication {

	@Autowired
	@Qualifier("uppercase")
	UpperCase uppercase;

	@Autowired
	@Qualifier("reversestring")
	ReverseString reversestring;

	public static void main(String[] args) {
		SpringApplication.run(SpringCfApplication.class, args);
	}

	@Bean
	Function<String, String> compositeFunction() {
		return value -> uppercase.compose(reversestring).apply(value);
	}
}
