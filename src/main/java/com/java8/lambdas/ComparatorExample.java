package com.java8.lambdas;

import java.util.Comparator;

/**
 * Created by georgekankava on 09.07.17.
 */
public class ComparatorExample {
    public static void main(String[] args) {
        // Lambda expression
        Comparator<Apple> appleComparator = Comparator.comparing((apple -> apple.getWeight()));
        // Method reference expression
        appleComparator = Comparator.comparing(Apple::getWeight);
    }

    public interface Apple {
        int getWeight();
    }
}
