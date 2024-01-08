package com.java8.streams;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    }
}
