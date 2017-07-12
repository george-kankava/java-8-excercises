package com.java8.lambdas;

import com.sun.java.accessibility.util.Translator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;
import static java.util.Comparator.comparing;

import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * Created by georgekankava on 11.07.17.
 */
public class TransactionStreamExample {

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

    public String getTranderNames(List<Transaction> transactions) {
        return transactions
                .stream()
                .map(transaction -> transaction.getTrader().getName())
                .sorted()
                .collect(joining());
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


    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario","Milan");
    Trader alan = new Trader("Alan","Cambridge");
    Trader brian = new Trader("Brian","Cambridge");
    List<Transaction> transactions = Arrays.asList(
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
    public class Trader {
        private final String name;
        private final String city;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @ToString
    public class Transaction {
        private final Trader trader;
        private final int year;
        private final int value;
    }
}
