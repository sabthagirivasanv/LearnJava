package com.thread;

class Counter{
    private int count;

    public void increment(){
        synchronized(this){
            count = count + 1;
        }
        //System.out.println(Thread.currentThread().getName()+": "+count);
    }

    public int getCount() {
        return count;
    }
}

public class Synchronization {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        }, "Thread 1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        }, "Thread 2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(counter.getCount());
    }
}
