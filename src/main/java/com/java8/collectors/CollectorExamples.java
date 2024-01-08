package com.java8.collectors;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;

public class CollectorExamples {

    public static void main(String[] args) {
        List<Dish> dishes = List.of(new Dish("dish1", 500, DishType.FISH),
                new Dish("dish2", 700, DishType.MEAT),
                new Dish("dish3", 1000, DishType.VEGETARIAN),
                new Dish("dish4", 400, DishType.FISH),
                new Dish("dish5", 550, DishType.FISH),
                new Dish("dish6", 250, DishType.VEGETARIAN),
                new Dish("dish7", 750, DishType.MEAT));
        Map<DishType, Map<CaloricLevel, List<Dish>>> collect = dishes.stream()
                .collect(groupingBy(Dish::type,
                        groupingBy(dish -> {
                            if (dish.calories() <= 400)
                                return CaloricLevel.DIET;
                            else if (dish.calories() <= 700) return
                                    CaloricLevel.NORMAL;
                            else
                                return CaloricLevel.FAT;
                        })));
        System.out.println(collect);

        // count dishes by DishType
        Map<DishType, Optional<Dish>> dishTypeLongMap = dishes.stream()
                .collect(groupingBy(Dish::type, maxBy(Comparator.comparingInt(Dish::calories))));
        System.out.println(dishTypeLongMap);


    }

    public enum DishType {
        FISH, MEAT, VEGETARIAN
    }

    public enum CaloricLevel {DIET, NORMAL, FAT}

    public record Dish(String name, int calories, DishType type) {
    }

}
