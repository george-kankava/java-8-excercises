package com.java8.lambdas;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

/**
 * Created by georgekankava on 10.07.17.
 */
public class LimitDishesExample {

    public static List<Dish> limitDishesWithCaloriesAmount(List<Dish> dishes, final int calories, int limit) {
        return dishes.stream()
                .filter(dish -> dish.getCalories() < calories)
                .limit(limit)
                .collect(toList());
    }

    public static void main(String[] args) {
    }

    public interface Dish {
        int getCalories();
    }
}


