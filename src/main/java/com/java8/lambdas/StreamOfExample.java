package com.java8.lambdas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by georgekankava on 15.07.17.
 */
public class StreamOfExample {
    public static void main(String[] args) {
        Stream<String> steam = Stream.of("A", "B", "C");
        OptionalInt max = steam
                .mapToInt(value -> value.toCharArray()[0])
                .max();
        System.out.println(max.getAsInt());

        List<Dish> dishList = IntStream
                .of(3, 2, 4, 0, 9, 8, 12, 83, 120)
                .boxed()
                .map(operand -> new Dish(operand))
                .sorted(Comparator.comparing( Dish::getCalories).reversed())
                .collect(Collectors.toList());
        System.out.println(dishList);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @ToString
    private static class Dish {
        private int calories;
    }
}
