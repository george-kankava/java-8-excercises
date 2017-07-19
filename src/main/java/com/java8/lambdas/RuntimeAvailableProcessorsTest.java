package com.java8.lambdas;

/**
 * Created by georgekankava on 19.07.17.
 */
public class RuntimeAvailableProcessorsTest {
    public static void main(String[] args) {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println(availableProcessors);
    }
}
