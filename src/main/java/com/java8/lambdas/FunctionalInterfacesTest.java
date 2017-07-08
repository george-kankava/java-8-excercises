package com.java8.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Created by georgekankava on 08.07.17.
 */
public class FunctionalInterfacesTest {

    public static <T, R> List<R> functionTest(List<T> list, Function<T, R> function) {
        final List<R> returnList = new ArrayList<R>();
        for (T element : list) {
            returnList.add(function.apply(element));
        }
        return returnList;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Hi", "There", "I", "Want", "Into", "The", "USA");
        functionTest(list, (String s) -> {return s.length();});
    }
}
