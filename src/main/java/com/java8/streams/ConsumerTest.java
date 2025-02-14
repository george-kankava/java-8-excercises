package com.java8.streams;

import java.util.function.Consumer;

public class ConsumerTest {

    public static void main(String[] args) {
        Consumer<String> consumer = (s) -> System.out.println(s.toUpperCase());
        consumer.andThen((s) -> System.out.println(s.toLowerCase()))
                .andThen((s) -> System.out.println(s + " Testing."))
                .accept("Java8");
    }
}
