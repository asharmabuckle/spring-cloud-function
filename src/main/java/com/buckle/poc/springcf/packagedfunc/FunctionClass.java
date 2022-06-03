//package com.buckle.poc.springcf.packagedfunc;
//
//import java.util.function.Function;
//
//public class FunctionClass implements Function<String, String> {
//
//    @Override
//    public String apply(String s) {
//        return null;
//    }
//
//    @Override
//    public <V> Function<V, String> compose(Function<? super V, ? extends String> before) {
//        return Function.super.compose(before);
//    }
//
//    @Override
//    public <V> Function<String, V> andThen(Function<? super String, ? extends V> after) {
//        return Function.super.andThen(after);
//    }
//}
