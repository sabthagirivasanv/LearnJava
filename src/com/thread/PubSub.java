package com.thread;

class Queue{

    private boolean isProduced = false;
    private int count = 0;
    public int getCount() {
        return count;
    }

    public synchronized void produce() throws InterruptedException {
        while(isProduced){
            wait();
        }
        count= count + 1;
        isProduced = true;
        System.out.println("Produced : "+count);
        notify();
    }

    public synchronized void consume() throws InterruptedException {
        while (!isProduced){
            wait();
        }
        count = count - 1;
        isProduced = false;
        System.out.println("Consumed : "+count);
        notify();
    }

}

class Producer implements Runnable{

    private Queue queue;

    public Producer(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            produce();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void produce() throws InterruptedException {
        int i = 0;
        while(i < 20){
            queue.produce();
            Thread.sleep(500);
            i++;
        }
    }

}
class Consumer implements Runnable{

    private Queue queue;

    public Consumer(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            consume();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void consume() throws InterruptedException {
        int i = 0;
        while(i < 20){
            queue.consume();
            Thread.sleep(500);
            i++;
        }
    }

}

public class PubSub {
    public static void main(String[] args) throws InterruptedException {
        Queue queue = new Queue();
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        //Thread.sleep(100);
        consumerThread.start();

        producerThread.join();
        consumerThread.join();

        System.out.println(Thread.currentThread().getName()+": PubSub Ended!!!");
    }
}








