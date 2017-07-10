package com.java8.lambdas;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by georgekankava on 10.07.17.
 */
public class StreamExample {

    public List<String> lowCaloricDishes(List<Dish> menu) {
        return menu.stream()
                    .filter(dish -> dish.getCalories() < 400)
                    .sorted(Comparator.comparing(Dish::getCalories))
                    .map(dish -> dish.getName())
                    .collect(Collectors.toList());
    }

    public static void main(String[] args) {

    }

    public interface Dish {
        int getCalories();
        String getName();
    }
}
