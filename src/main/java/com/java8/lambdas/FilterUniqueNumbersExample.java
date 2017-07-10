package com.java8.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by georgekankava on 10.07.17.
 */
public class FilterUniqueNumbersExample {

    public static void printDistinctNumbersInList(List<Integer> integers) {
        integers.stream()
                .filter(integer -> integer % 2 ==0)
                .distinct()
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        printDistinctNumbersInList(numbers);
    }
}
