package com.java8.lambdas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by georgekankava on 15.07.17.
 */
public class StreamGroupingExample {

    public static void main(String[] args) {
        Stream<Data> stream = Stream.of(
                new Data(1, "1"),
                new Data(2, "2"),
                new Data(2, "2"),
                new Data(3, "3"));
        Map<Integer, Long> collect = stream
                .collect(Collectors.groupingBy(Data::getId, Collectors.counting()));
        System.out.println(collect);

    }

    @Getter
    @Setter
    @ToString
    @AllArgsConstructor
    private static class Data {
        private int id;
        private String data;
    }
}
