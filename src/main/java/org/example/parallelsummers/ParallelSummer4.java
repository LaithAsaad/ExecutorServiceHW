package org.example.parallelsummers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.example.summers.SummerCallable;
import org.example.summers.SummerThread;
import org.example.worker.WorkPartitioner;


public class ParallelSummer4{

    public static long sum(int[] data, int threadCount) {
		/*
		The sum function is used to distribute the task among threads for the completion of the mission.
		The result of this operation is the count of prime numbers.
		Note that the function use SummerCallable which it's run methods return future,
		so you have to use for loop to get the result.
		*/
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        List<Future<Long>> results = new ArrayList<Future<Long>>();
        List<WorkPartitioner.Part> parts =  WorkPartitioner.partitions(data.length, threadCount);

        for (WorkPartitioner.Part part : parts) {
            results.add(executor.submit(new SummerCallable(data, part)));
        }

        executor.shutdown();

        while (!executor.isTerminated()) {
        }

        long sum = 0;
        for (Future<Long> future : results) {
            try {
                sum += future.get();
            } catch (InterruptedException | ExecutionException e) {
                System.err.println("Cannot get the results from threads.");
                return -2;
            }
        }

        System.out.println("summer4 " + sum);
        return sum;
    }


}
