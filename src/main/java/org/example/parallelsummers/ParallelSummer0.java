package org.example.parallelsummers;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.example.summers.SummerRunnable;
import org.example.summers.SummerThread;
import org.example.worker.WorkPartitioner;



public class ParallelSummer0{
    /*
    The sum function is used to distribute the task among threads for the completion of the mission.
    The result of this operation is the count of prime numbers.
    */
    public static long sum(int[] data, int threadCount) {

        List<SummerThread> summers =  new ArrayList<>();
        List<WorkPartitioner.Part> parts =  WorkPartitioner.partitions(data.length, threadCount);

        for (WorkPartitioner.Part part : parts) {
            summers.add(new SummerThread(data,part));
        }

        for (SummerThread summerThread : summers) {
            summerThread.start();
        }

        for (SummerThread summerThread : summers) {
            try {
                summerThread.join();
            } catch (InterruptedException e) {
                System.err.println("Thread cannot join!");
            }
        }


        long sum = 0;
        for (SummerThread summerThread : summers) {
            sum += summerThread.getSum();
        }
        System.out.println("summer0 " + sum);
        return sum;

    }


}
