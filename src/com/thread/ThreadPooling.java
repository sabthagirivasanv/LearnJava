package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPooling implements Runnable{
    private String name;

    public ThreadPooling(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("-> "+name +" "+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newCachedThreadPool();

        threadPool.execute(new ThreadPooling("Thread 1"));
        threadPool.execute(new ThreadPooling("Thread 2"));
        threadPool.execute(new ThreadPooling("Thread 3"));
        threadPool.execute(new ThreadPooling("Thread 4"));
        threadPool.execute(new ThreadPooling("Thread 5"));

        threadPool.shutdown();
        
        System.out.println("end main");
    }
}
