package org.example;
import org.example.data.TestData;
import org.example.parallelsummers.*;

public class Main {
    public static void main(String[] args) {
        /*
        Use Main function to make unit testing
        */
        int start = 0;
        int end = 20;
        int[] data = TestData.createData(start, end);
        long result = SequentialSummer.sum(SequentialSummer.allPrimes(data));
        System.out.println("result is " + result);
        int threadCount = 25;
        System.out.println("Sequential summer:" + result);
        System.out.println("Parallel summer 1: " + ParallelSummer0.sum(data, threadCount));
        System.out.println("Parallel summer 2: " + ParallelSummer1.sum(data, threadCount));
        System.out.println("Parallel summer 3: " + ParallelSummer2.sum(data, threadCount));
        System.out.println("Parallel summer 4: " + ParallelSummer3.sum(data, threadCount));
        System.out.println("Parallel summer 5: " + ParallelSummer4.sum(data, threadCount));

    }
}