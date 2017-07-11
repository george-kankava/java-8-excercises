package com.java8.lambdas;

import java.util.Comparator;
import java.util.List;
import static java.util.stream.Collectors.toList;

/**
 * Created by georgekankava on 10.07.17.
 */
public class StreamExample {

    public List<String> lowCaloricDishes(List<Dish> menu) {
        return menu.stream()
                    .filter(dish -> dish.getCalories() < 400)
                    .sorted(Comparator.comparing(Dish::getCalories))
                    .map(dish -> dish.getName())
                    .collect(toList());
    }

    public List<Dish> skipFirstTwoElements(List<Dish> dishes) {
        return dishes.stream()
                    .filter(dish -> dish.getCalories() < 300)
                    .skip(2)
                    .collect(toList());
    }

    public static void main(String[] args) {

    }

    public interface Dish {
        int getCalories();
        String getName();
    }
}
