package com.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamSecondConsumption {

    public static void main(String[] args) {
        List<String> title = Arrays.asList("Java8", "in", "action");
        Stream<String> stream = title.stream();
        stream.forEach(System.out::println);
        // thorws java.lang.IllegalStateException: stream has already been operated upon or closed
        stream.forEach(System.out::println);

    }
}
