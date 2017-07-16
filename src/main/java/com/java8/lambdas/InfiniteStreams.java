package com.java8.lambdas;

import java.util.stream.Stream;

/**
 * Created by georgekankava on 16.07.17.
 */
public class InfiniteStreams {
    public static void main(String[] args) {
        Stream
                .iterate(1, integer -> integer)
                .limit(10)
                .forEach(System.out::println);

        Stream
                .generate(Math::random)
                .limit(10)
                .forEach(System.out::println);

    }
}
