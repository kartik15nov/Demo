package com.Demo;

//This code is to get the sum of an array using 2 methods, using parallel and sequential way and the time calculation.

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinDemo {
    static double sum;

    private ForkJoinDemo() {

    }

    protected static double seqArraySum(double[] x) {
        long startTime = System.nanoTime();

        sum = 0;
        for (int i = 0; i < x.length; i++)
            sum += 1 / x[i];

        long timeInNanos = System.nanoTime() - startTime;

        printResults("seqArraySum", timeInNanos, sum);
        return sum;
    }

    protected static double parArraySum(double[] x) {
        long startTime = System.nanoTime();
        SumArray t = new SumArray(x, 0, x.length);
        ForkJoinPool.commonPool().invoke(t);

        double sum = t.ans;
        long timeInNanos = System.nanoTime() - startTime;
        printResults("parArraySum", timeInNanos, sum);
        return sum;
    }


    private static class SumArray extends RecursiveTask {

        static int SEQUENTIAL_THRESHOLD = 1000;

        int lo;
        int hi;
        double[] arr;
        double ans = 0;

        SumArray(double[] a, int l, int h) {

            lo = l;
            hi = h;
            arr = a;
        }
        @Override
        protected Double compute() {
            // TODO Auto-generated method stub

            if (hi - lo <= SEQUENTIAL_THRESHOLD) {
                for (int i = lo; i < hi; i++)
                    ans += 1 / arr[i];
            } else {

                SumArray left = new SumArray(arr, lo, (hi + lo) / 2);
                SumArray right = new SumArray(arr, (hi + lo) / 2, hi);
                left.fork();
                double rightSum = right.compute();
                double leftSum = (double) left.join();

                // ans=left.ans + right.ans;

                ans = leftSum + rightSum;
            }
            return ans;

        }

    }

    private static void printResults(String name, long timeInNanos, double sum) {
        System.out.printf(" %s completed in %8.3f milliseconds, with sum = %8.5f \n", name, timeInNanos / 1e6, sum);
    }

    public static void main(String[] args) {

        final double[] x = new double[99999999];

        for (int i = 0; i < x.length; i++) {
            x[i] = (i + 1);
        }

        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "4");

        for (int numRun = 0; numRun < 5; numRun++) {
            System.out.printf("Run %d\n", numRun);
            seqArraySum(x);
            parArraySum(x);
        }
    }


}
