package com.java8.lambdas;

/**
 * Created by georgekankava on 30.07.17.
 */
public class ProducerConsumerExample {

    public static class Consumer implements Runnable {
        Data data;
        public Consumer(Data data) {
            this.data = data;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (data) {
                    if (data.flag) {
                        try {
                            data.wait();
                            data.take();
                            data.flag = false;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        data.notifyAll();
                    }
                }
            }
        }
    }

    public static class Producer implements Runnable {
        Data data;
        public Producer(Data data) {
            this.data = data;
        }

        @Override
        public void run() {
            while (true) {
                    synchronized (data) {
                        if (!data.flag) {
                            try {
                                data.wait();
                                data.put();
                                data.flag = true;
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                            data.notifyAll();
                        }
                    }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Data data = new Data();
        Thread thread1 = new Thread(new Producer(data));
        Thread thread2 = new Thread(new Consumer(data));
        thread1.start();
        thread2.start();
    }

    private static class Data {
        volatile boolean flag = false;
        int item = 0;

        public void put() {
            System.out.println("Producing data " + ++item);
        }

        public int take() {
            System.out.println("Consuming data " + item);
            return item;
        }
    }
}
