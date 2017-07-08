package com.java8.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

/**
 * Created by georgekankava on 08.07.17.
 */
public class ConsumerInterfaceTest {

    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T t : list) {
            c.accept(t);
        }
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c");
        forEach(list, (s) -> System.out.println(s));

    }
}
