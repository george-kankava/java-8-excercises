package com.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FlatMapAndReduceExample {

    public static void main(String[] args) {
        List<String> l1 = Arrays.asList("a", "b", "c");
        List<String> l2 = Arrays.asList("c", "d");
        List<List<String>> list = Arrays.asList(l1, l2);
        list.stream()
                .flatMap(e -> e.stream())
                .distinct()
                .forEach(System.out::print);

        System.out.println();
        String reduce = l1.stream().reduce("d", (a, b) -> {
            System.out.println(a + " : " + b);
            return a + b;
        });
        System.out.println();
        System.out.println(reduce);
        System.out.println();

        List<Integer> integers = Arrays.asList(7, 1, 2, 11, 3, 4, 5);
        Integer integer = integers.stream()
                .reduce(0, (a, b) -> {
                    System.out.println(a + " : " + b);
                    return a + b;
                });
        System.out.println(integer);

        System.out.println();

        integer = integers.stream()
                .reduce(0, Integer::sum);
        System.out.println("Integer::sum " + integer);

        Integer max = integers.stream()
            .reduce(Integer.MIN_VALUE, (a, b) -> {
                if (a < b) {
                  return b;
                }
                return a;
            });
        System.out.println();
        System.out.println("max : " + max);
        System.out.println();

        Integer min = integers.stream()
                .reduce(Integer.MAX_VALUE, (a, b) -> {
                    System.out.println(a + " : " + b);
                    if (a < b) {
                        return a;
                    }
                    return b;
                });
        System.out.println();
        System.out.println("min : " + min);

        Optional<Integer> optMax = integers.stream().reduce(Integer::max);
        optMax.ifPresent(System.out::println);

        Optional<Integer> optMin = integers.stream().reduce(Integer::min);
        optMin.ifPresent(System.out::println);

    }
}
