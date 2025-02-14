package com.java8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class FIlterEvenNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4); numbers.stream()
                .filter(i -> i % 2 == 0)
                .sorted(Comparator.naturalOrder())
                .distinct()
                .forEach(System.out::println);

        List<Integer> dishes = numbers.stream()
                .filter(d -> d > 4)
                .skip(2)
                .toList();

    }
}
