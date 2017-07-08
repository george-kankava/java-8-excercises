package com.java8.lambdas;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

/**
 * Created by georgekankava on 08.07.17.
 */
public class PredicateVsIntPredicate {

    public static void main(String[] args) {
        IntPredicate intPredicate = (int i) -> i % 2 == 0;
        intPredicate.test(1000);

        Predicate<Integer> predicate = (Integer i) -> i % 2 == 0;
        predicate.test(1000);
    }
}
