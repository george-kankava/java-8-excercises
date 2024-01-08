package com.java8.lambdas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;
import static java.util.Comparator.comparing;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * Created by georgekankava on 11.07.17.
 */
public class TransactionStreamExample {

    public void generateExample() {
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
    }

    public void streamFromArrays() {
        int arr [] = {1, 2, 3, 4, 5};
        Arrays.stream(arr).sum();
    }

    public Stream getEmptyStream() {
        return Stream.empty();
    }

    public void streamOfExample() {
        Stream.of("Java", "8", "Programming")
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    public Transaction findTransactionsSmallesValue(List<Transaction> transactions) {
        return transactions
                .stream()
                .min(Comparator.comparing(Transaction::getValue))
                .get();
    }

    public int getMaxTransactionsValue(List<Transaction> transactions) {
        return transactions
                .stream()
                .map(transaction -> transaction.getValue())
                .reduce(Integer::max)
                .get();
    }

    public boolean anyMatchTraderInCity(List<Transaction> transactions, String city) {
        return transactions
                .stream()
                .anyMatch(transaction -> transaction
                        .getTrader()
                        .getCity()
                        .equals(city));
    }

    public static String getTranderNames(List<Transaction> transactions) {
        return transactions
                .stream()
                .map(transaction -> transaction.getTrader().getName())
                .sorted()
                .collect(joining(", "));
    }

    public static void main(String[] args) {
        System.out.println(getTranderNames(transactions));
    }

    public List<Transaction> findAllTransactionsWithYear(List<Transaction> transactions, int year) {
        return transactions.stream()
                .filter(transaction -> transaction.getYear() == year)
                .sorted(comparing(Transaction::getValue))
                .collect(toList());

    }

    public List<String> getTranderUniqueCities(List<Transaction> transactions) {
        return transactions
                .stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(toList());
    }

    public List<Trader> findTradersByCity(List<Transaction> transactions, String city) {
        return transactions
                .stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals(city))
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(toList());
    }


    static Trader raoul = new Trader("Raoul", "Cambridge");
    static Trader mario = new Trader("Mario","Milan");
    static Trader alan = new Trader("Alan","Cambridge");
    static Trader brian = new Trader("Brian","Cambridge");
    static public List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    @Getter
    @Setter
    @AllArgsConstructor
    @ToString
    public static class Trader {
        private final String name;
        private final String city;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @ToString
    public static class Transaction {
        private final Trader trader;
        private final int year;
        private final int value;
    }
}
