package com.buckle.poc.springcf;


import com.buckle.poc.springcf.packagedfunc.ReverseString;
import com.buckle.poc.springcf.packagedfunc.UpperCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestFunctionType {

    @Autowired
    UpperCase upperCase;
    @Autowired
    ReverseString reverseString;

    @Autowired
    Function<String, String> compositeFunction;

    String testString = "buckle before anything else.";

    @Test
    public void testUpperCase() {

        String funcRes = upperCase.apply(testString);

        assertEquals(funcRes, testString.toUpperCase());
    }

    @Test
    public void testReverseString() {
        StringBuilder strBldr = new StringBuilder(testString);

        String funcRes = reverseString.apply(testString);
        assertEquals(funcRes, strBldr.reverse().toString());
    }

    @Test
    public void testComposite_function() {
        String funcRes = compositeFunction.apply(testString);

        StringBuilder strBldr = new StringBuilder(testString.toUpperCase());
        assertEquals(funcRes, strBldr.reverse().toString());
    }
}
