package com.java8.lambdas;

/**
 * Created by georgekankava on 01.08.17.
 */
public class DeadlockExample {
    public static void main(String[] args) {
        Class1 class1 = new Class1();
        Class2 class2 = new Class2();
        Thread thread1 = new Thread(() -> {
            try {
                class1.method1(class2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                class2.method2(class1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        thread2.start();
    }

    public static class Class1 {
        public synchronized void method1(Class2 class2) throws InterruptedException {
            Thread.sleep(100);
            class2.method2(null);
        }
    }

    public static class Class2 {
        public synchronized void method2(Class1 class1) throws InterruptedException {
            Thread.sleep(100);
            class1.method1(null);
        }
    }
}
