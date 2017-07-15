package com.java8.lambdas;

import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by georgekankava on 15.07.17.
 */
public class RangeExample {
    public static void main(String[] args) {
        int sum = IntStream
                .range(1, 100)
                .sum();
        System.out.println(sum);

        sum = IntStream
                .rangeClosed(1, 100)
                .sum();
        System.out.println(sum);
        OptionalInt any = IntStream
                .range(1, 100)
                .filter(value -> value % 10 == 0)
                .findAny();
        System.out.println(any.orElse(0));
    }
}
