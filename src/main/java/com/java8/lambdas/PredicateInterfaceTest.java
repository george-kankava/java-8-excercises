package com.java8.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by georgekankava on 08.07.17.
 */
public class PredicateInterfaceTest {

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> filteredList = new ArrayList<>();
        for (T t : list) {
            if (p.test(t)) {
                filteredList.add(t);
            }
        }
        return filteredList;
    }

    public static void main(String[] args) {
        List<String> listOfStrings = Arrays.asList("1", "", "3");
        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        filter(listOfStrings, nonEmptyStringPredicate);
    }
}
