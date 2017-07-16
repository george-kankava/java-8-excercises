package com.java8.lambdas;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by georgekankava on 16.07.17.
 */
public class StreamDistinctCharsInWordsExample {
    public static void main(String[] args) {
        Stream
                .of("Hello", "There", "What", "Are" ,"You", "Up", "To")
                .map(s -> s.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .forEach(System.out::print);
    }
}
