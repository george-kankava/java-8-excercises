package com.java8.optionals;

import java.util.Optional;

public class TestingOptionals {

    private static Car car;

    public static void main(String[] args) {
        Optional<Car> optCar = Optional.ofNullable(car);
    }
}

