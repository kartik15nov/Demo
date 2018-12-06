package com.Demo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Requirement is to 4 tasks must execute concurrently and the 5th task should wait to start till first 4 completes
//This method is implemented with Cyclic Barrier

public class CyclicBarrierDemo {

    public static void main(String[] args) {

        CyclicBarrier barrier = new CyclicBarrier(4, () -> {
            System.out.println("Barrier Check Point");
            new Thread(() -> System.out.println(Thread.currentThread().getName() + " started after reaching all threads at CB")).start();
        });

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 4; i++) {
            executorService.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " started");
                try {
                    barrier.await();
                } catch (BrokenBarrierException | InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

    }
}
