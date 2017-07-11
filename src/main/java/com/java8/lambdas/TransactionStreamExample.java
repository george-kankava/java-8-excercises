package com.java8.lambdas;

import com.sun.java.accessibility.util.Translator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import static java.util.stream.Collectors.toList;

/**
 * Created by georgekankava on 11.07.17.
 */
public class TransactionStreamExample {

    public List<Transaction> findAllTransactionsWithYear(List<Transaction> transactions, int year) {
        return transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
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
