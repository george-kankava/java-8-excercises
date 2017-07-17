package com.java8.lambdas;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by georgekankava on 17.07.17.
 */
public class CollectorReducingExample {
    public static void main(String args[]) {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7);
        Optional<Integer> reduce = integerStream.reduce((integer, integer2) -> integer > integer2 ? integer : integer2);
        System.out.println(reduce.orElse(0));

        Stream
                .of(1, 21)
                .collect(Collectors.reducing(0, (o, o2) -> Integer.max(o, o2)));
    }
}
