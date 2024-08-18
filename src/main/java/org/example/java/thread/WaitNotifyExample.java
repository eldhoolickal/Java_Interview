package org.example.java.thread;

public class WaitNotifyExample {

    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        Producer producer = new Producer(resource);
        Consumer consumer = new Consumer(resource);

        producer.start();
        consumer.start();
    }

}

class SharedResource {
    private int data;
    private boolean available = false;

    public synchronized void produce(int value) {
        while (available) {
            try {
                wait();  // Wait until the data is consumed
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        data = value;
        available = true;
        System.out.println("Produced: " + value);
        notify();  // Notify the consumer that data is available
    }

    public synchronized void consume() {
        while (!available) {
            try {
                wait();  // Wait until data is produced
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        available = false;
        System.out.println("Consumed: " + data);
        notify();  // Notify the producer that the data has been consumed
    }
}

class Producer extends Thread {
    private SharedResource resource;

    public Producer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            resource.produce(i);
        }
    }
}

class Consumer extends Thread {
    private SharedResource resource;

    public Consumer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            resource.consume();
        }
    }
}
