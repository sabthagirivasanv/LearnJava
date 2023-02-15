package com.thread;


import java.util.stream.Stream;

class Printer1 extends Thread{
    public void run(){
        Stream.iterate(1, a -> a+1)
                .limit(5)
                .forEach(x -> {
                    System.out.println(x);
                    try {
                        //System.out.println(Thread.currentThread().getName());
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
    }
}

class Printer2 extends Thread{
    public void run(){
        Stream.iterate(101, a -> a+1)
                .limit(5)
                .forEach(x -> {
                    //System.out.println(Thread.currentThread().getName());
                    System.out.println(x);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
    }
}

public class ExtendedTread {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());

        Printer1 p1 = new Printer1();
        Printer2 p2 = new Printer2();
        p1.setPriority(Thread.MAX_PRIORITY);
        p2.setPriority(Thread.MIN_PRIORITY);
        p1.start();
        p2.start();

        p1.join();
        p2.join();
        System.out.println("End");
    }
}
