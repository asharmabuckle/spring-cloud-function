package com.buckle.poc.springcf.packagedfunc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@Qualifier("uppercase")
public class UpperCase implements Function<String, String> {

    @Override
    public String apply(String s) {
        return s.toUpperCase();
    }
}
