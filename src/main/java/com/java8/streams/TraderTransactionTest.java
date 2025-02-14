package com.java8.streams;

import lombok.Getter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TraderTransactionTest {

    public static void main(String[] args) {
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

        transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());

        transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());

        transactions.stream()
                .map(t -> t.getTrader().getCity())
                .collect(Collectors.toSet());


        Stream.of(raoul, mario, alan, brian)
                .map(Trader::getCity)
                .distinct()
                .toList();

        transactions.stream()
                .map(t -> t.getTrader())
                .filter(t -> t.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());

        transactions.stream()
                .map(transaction -> transaction.getTrader())
                .map(Trader::getName)
                .sorted()
                .reduce("", (a, b) -> a + b );

        transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining());

        transactions.stream()
                .anyMatch(transaction -> transaction
                        .getTrader()
                        .getCity()
                        .equals("Milan"));

        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(transaction -> transaction.getValue())
                .forEach(System.out::println);

        transactions.stream()
                .map(transaction -> transaction.getValue())
                .reduce(Integer::max);

        transactions.stream()
                .sorted(Comparator.comparing(Transaction::getValue).reversed())
                .findFirst();

        transactions.stream()
            .reduce( (transaction, transaction2) -> {
                return transaction.getValue() < transaction2.getValue() ? transaction : transaction2;
            });

        transactions.stream()
                .min(Comparator.comparing(Transaction::getValue));



    }

    public static class Trader {
        private final String name;
        private final String city;

        public Trader(String name, String city) {
            this.name = name;
            this.city = city;
        }

        public String getName() {
            return name;
        }

        public String getCity() {
            return city;
        }
    }

    @Getter
    public static class Transaction {
        private final Trader trader;
        private final int year;
        private final int value;

        public Transaction(Trader trader, int year, int value) {
            this.trader = trader;
            this.year = year;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Transaction{" +
                    "trader=" + trader +
                    ", year=" + year +
                    ", value=" + value +
                    '}';
        }
    }
}
