package com.java8.lambdas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import static java.util.stream.Collectors.toList;

/**
 * Created by georgekankava on 10.07.17.
 */
public class StreamExample {

    public List<String> extractDishNames(List<Dish> dishes) {
        return dishes.stream()
                    .map(dish -> dish.getName())
                    .collect(toList());
    }

    public List<Integer> squareOfNumbers(List<Integer> numbers) {
        return numbers.stream()
                    .map(n -> n * n)
                    .collect(toList());
    }

    public List<Integer> extractDishNamesLength(List<Dish> dishes) {
        return dishes.stream()
                .map(dish -> dish.getName())
                .map(s -> s.length())
                .collect(toList());
    }

    public List<String> distinctLettersInWord(List<String> words) {
        return words.stream()
                .map(word -> word.split(""))
                .flatMap(strings -> Arrays.stream(strings))
                .distinct()
                .collect(toList());
    }

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
