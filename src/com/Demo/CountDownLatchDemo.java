package com.Demo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


//Requirement is to 4 tasks must execute concurrently and the 5th task should wait to start till first 4 completes
//This method is implemented with CountDownLatch

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(4);

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 4; i++) {
            executorService.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " started");
                latch.countDown();
            });
        }

        latch.await();
        new Thread(() -> System.out.println(Thread.currentThread().getName() + " Last Thread started")).start();

    }
}
