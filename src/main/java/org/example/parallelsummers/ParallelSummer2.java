package org.example.parallelsummers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import org.example.summers.SummerThread;
import org.example.worker.WorkPartitioner;


public class ParallelSummer2{

    public static long sum(int[] data, int threadCount) {
		/*
		The sum function is used to distribute the task among threads for the completion of the mission.
		The result of this operation is the count of prime numbers.
		Note that the function use SummerThread which it's run methods return void,
		so you have to use for loop to get the result.
		*/
        List<SummerThread> summers =  new ArrayList<>();
        List<WorkPartitioner.Part> parts =  WorkPartitioner.partitions(data.length, threadCount);

        for (WorkPartitioner.Part part : parts) {
            summers.add(new SummerThread(data,part));
        }

        ExecutorService executor = Executors.newFixedThreadPool(threadCount);

        for (SummerThread summer: summers) {
            executor.execute(summer);
        }

        executor.shutdown();

        //Waiting for all the thread to finalize
        while (!executor.isTerminated()) {
        }

        System.out.println("summer2 "+ summers.stream().mapToLong(SummerThread::getSum).sum());
        return summers.stream().mapToLong(SummerThread::getSum).sum();
    }


}
