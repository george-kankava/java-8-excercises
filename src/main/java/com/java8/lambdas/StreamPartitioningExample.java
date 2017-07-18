package com.java8.lambdas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by georgekankava on 18.07.17.
 */
public class StreamPartitioningExample {
    public static void main(String[] args) {
        Map<Boolean, List<Dish>> collect = Stream
                .of(
                        new Dish("Chakapuli", 400, false),
                        new Dish("Chikirtma", 300, false),
                        new Dish("Mtsvadi", 400, false),
                        new Dish("Lobiani", 400, true),
                        new Dish("Pkhali", 400, true)
                )
                .collect(Collectors.partitioningBy(Dish::isVegetarian));
        System.out.println(collect);
    }

    @Setter
    @Getter
    @AllArgsConstructor
    private static class Dish {
        private String name;
        private int calories;
        private boolean vegetarian;
    }
}
