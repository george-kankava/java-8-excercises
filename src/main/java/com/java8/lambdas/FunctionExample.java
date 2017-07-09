package com.java8.lambdas;

import java.util.function.Function;

/**
 * Created by georgekankava on 09.07.17.
 */
public class FunctionExample {
    public static void main(String[] args) {
        Function<Integer, Integer> functionA = integer -> integer + 2;
        Function<Integer, Integer> functionB = integer -> integer * 2;
        // Nesting functions
        Function<Integer, Integer> functionC = functionA.andThen(functionB);
    }
}
