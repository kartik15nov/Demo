package com.Demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

//Printing numbers sequentially by 4 threads.

// T1 - 1,5,9
// T2 - 2,6,10
// T3 - 3,7,11
// T4 - 4,8,12

public class ThreadDemo1 {

    static AtomicInteger number = new AtomicInteger(0);

    public static void main(String[] args){

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for(int i=0;i<4;i++){
            int j=i;
            executorService.execute(()-> {
                while (number.get() < 12) {
                    if (number.get() % 4 == j) {
                        int value = number.get() + 1;
                        Thread.currentThread().setName("Thread-"+(j+1));
                        System.out.println(Thread.currentThread().getName() + "  " + value);
                        number.incrementAndGet();
                    }
                }
            });
        }
    }
}
