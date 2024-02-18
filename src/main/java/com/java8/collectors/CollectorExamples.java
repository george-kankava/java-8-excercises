package com.java8.collectors;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toList;

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

        Map<Boolean, Dish> booleanDishMap = dishes.stream()
                .collect(partitioningBy(dish -> dish.type() == DishType.FISH || dish.type() == DishType.MEAT,
                        collectingAndThen(maxBy(Comparator.comparingInt(Dish::calories)), Optional::get)));
        System.out.println(booleanDishMap);
        Map<String, String> hashMap = new HashMap<>() {
            {
                System.out.println("Created");
                put("test", "testvalue");
                System.out.println(get("test"));
            }
            @Override
            public boolean isEmpty() {
                return super.isEmpty();
            }
        };



    }

    public Supplier<Map<Boolean, List<Integer>>> supplier() { return () -> new HashMap<Boolean, List<Integer>>() {{
        put(true, new ArrayList<Integer>());
        put(false, new ArrayList<Integer>()); }};
    }

    public enum DishType {
        FISH, MEAT, VEGETARIAN
    }

    public enum CaloricLevel {DIET, NORMAL, FAT}

    public record Dish(String name, int calories, DishType type) {
    }

}
