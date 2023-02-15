package com.thread;


import java.util.stream.Stream;


public class ImplementedThread {
    static class Printer1 implements Runnable{
        public void run(){
            Stream.iterate(1, a -> a+1)
                    .limit(5)
                    .forEach(x -> {
                        System.out.println(x);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    });
        }
    }

    static class Printer2 implements Runnable{
        public void run(){
            Stream.iterate(101, a -> a+1)
                    .limit(5)
                    .forEach(x -> {
                        System.out.println(x);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    });
        }
    }


    public static void main(String[] args) {
        Printer1 p1 = new Printer1();
        Printer2 p2 = new Printer2();

        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);

        t1.start();
        t2.start();
    }
}
