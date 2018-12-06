package com.Demo;

import java.util.concurrent.*;

//Requirement is to 4 tasks must execute concurrently and the 5th task should wait to start till first 4 completes
//This method is implemented with FutureTask

public class FutureTaskDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CountDownLatch latch = new CountDownLatch(3);

        for (int i = 0; i < 4; i++) {
            executorService.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " started");
                latch.countDown();
            });
        }

        latch.await();

        Future f = executorService.submit(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
            System.out.println("Future task");
        });
        f.get();
        System.out.println(f.isDone());
        System.out.println(f.isCancelled());
    }
}
