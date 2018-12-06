package com.Demo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 Threads are busy looping, which will lead to 100% CPU usage. You should synchronize the threads instead.
 **/
public class ThreadDemo {

    AtomicInteger sharedOutput = new AtomicInteger(0);

    public static void main(String args[]) {

        ThreadDemo t = new ThreadDemo();

        ThreadTasks t1 = t.new ThreadTasks(0);
        ThreadTasks t2 = t.new ThreadTasks(1);
        ThreadTasks t3 = t.new ThreadTasks(2);
        ThreadTasks t4 = t.new ThreadTasks(3);

        Thread ts1 = new Thread(t1);
        Thread ts2 = new Thread(t2);
        Thread ts3 = new Thread(t3);
        Thread ts4 = new Thread(t4);
        ts1.start();
        ts2.start();
        ts3.start();
        ts4.start();
    }

    private class ThreadTasks implements Runnable {

        private final int threadPosition;

        public ThreadTasks(int threadPosition) {
            super();

            this.threadPosition = threadPosition;
        }

        @Override
        public void run() {

            while (sharedOutput.get() < 11) {

                if (sharedOutput.get() % 4 == this.threadPosition) {

                    int value = sharedOutput.get() + 1;
                    System.out.println("Printing output for Thread: " + this.threadPosition + "  " + value);
                    sharedOutput.incrementAndGet();
                }
            }

        }
    }

}
