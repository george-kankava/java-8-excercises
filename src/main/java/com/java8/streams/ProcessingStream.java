package com.java8.streams;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ProcessingStream {

    public static void main(String[] args) {
        List<String> title = Arrays.asList("Java8", "in", "action");
        java.util.List<Integer> collect = title
                .stream()
                .filter((e) -> {
                    System.out.println("filter : " + e);
                    return e.length() > 4;
                })
                .map((e) -> {
                    System.out.println("map : " + e.length());
                    return e.length();
                })
                .collect(Collectors.toList());
        System.out.println(collect);

        // removed sout test1 branch

        Optional<Integer> sum = Stream.iterate(1, i -> i + 1)
                .limit(5)
                .parallel()
                .reduce(Integer::sum);

        System.out.println(sum.orElse(1));


        System.getenv();
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "12");


        long start = System.currentTimeMillis();

        Long longSum = LongStream.rangeClosed(0, 100)
                .parallel()
                .reduce(Long::sum)
                .orElse(0);

        long end = System.currentTimeMillis() - start;
        System.out.println("reduce(Long::sum) time : " + end);
        System.out.println(longSum);
    }
}
