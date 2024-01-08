package com.java8.streams;



import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreamExample {

    public static void main(String[] args) {
        List<Dish> dishes = Arrays.asList(new Dish(), new Dish(), new Dish());
        int sum = dishes.stream()
                .mapToInt(e -> e.getCalories())
                .sum();
        System.out.println(sum);

        java.util.List<Integer> boxed = dishes.stream()
                .mapToInt(Dish::getCalories)
                .boxed()
                .collect(Collectors.toList());

        OptionalInt max = dishes.stream()
                .mapToInt(e -> e.getCalories())
                .max();
        System.out.println(max.orElse(1));

        System.out.println(IntStream.range(1, 100).count());

        System.out.println(IntStream.range(1, 100).findFirst());

        System.out.println(IntStream.rangeClosed(1, 100).average());

        System.out.println(Stream.empty().count());

        int [] numbers = {1, 2, 3, 4, 5, 6, 7};
        int arraySum = Arrays.stream(numbers).sum();
        System.out.println("Arrays.stream(numbers).sum() : " + arraySum);

        String strArray [] = {"Java", "8", "In", "Action"};
        Stream<String> stream = Arrays.stream(strArray);

        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);

        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);


        // fibonacci with streams
        Stream.iterate(new int [] {0, 1}, a -> new int [] {a[1], a[0] + a[1]})
                .limit(10)
                .map(t -> String.format("%d ", t[0]))
                .forEach(value -> System.out.print(value));

    }
}

class Dish {
    int getCalories() {return 0;};
}
