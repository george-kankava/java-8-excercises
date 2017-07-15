package com.java8.lambdas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by georgekankava on 15.07.17.
 */
public class ArraysToStreamExample {
    public static void main(String[] args) {
        IntStream intStream =  Arrays.stream(new int [] {1, 2, 3, 4, 5, 6, 7, 8});
        System.out.println(intStream.sum());
        Stream<Dish> stream = Arrays.stream(new Dish[]{
            new Dish("Chakapuli", 400),
            new Dish("Satsivi", 300),
            new Dish("Khinkali", 100)
        });
        stream
                .map(Dish::getName)
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);
    }

    @Getter
    @Setter
    @ToString
    @AllArgsConstructor
    private static class Dish {
        private String name;
        private int calories;
    }
}
