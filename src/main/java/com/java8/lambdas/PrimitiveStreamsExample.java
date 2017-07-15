package com.java8.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by georgekankava on 15.07.17.
 */
public class PrimitiveStreamsExample {

    public int sumCalories(List<Dish> dishList) {
        return dishList
                .stream()
                .mapToInt(Dish::getCalories)
                .sum();
    }

    public void convertToNonSpecializedStream(List<Dish> dishes) {
        Stream<Integer> boxed = dishes
                .stream()
                .mapToInt(value -> value.getCalories())
                .boxed();
        boxed
                .mapToInt(value -> value * 2)
                .sum();

    }

    public interface Dish {
        int getCalories();
    }

    public static void main(String[] args) {
        List<Dish> dishes = Arrays.asList(() -> 1, () -> 2, () -> 3, () -> 4);
        int result = new PrimitiveStreamsExample().sumCalories(dishes);
        System.out.println(result);
    }
}
