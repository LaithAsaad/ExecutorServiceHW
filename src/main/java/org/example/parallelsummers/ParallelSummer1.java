package org.example.parallelsummers;
import java.util.ArrayList;
import java.util.List;

import org.example.summers.SummerRunnable;
import org.example.summers.SummerThread;
import org.example.worker.WorkPartitioner;


public class ParallelSummer1 {

    public static long sum(int[] data, int threadCount) {
		/*
		The sum function is used to distribute the task among threads for the completion of the mission.
		The result of this operation is the count of prime numbers.
		Note that the function use SummerRunnable which it's run methods return void,
		so you have to use for loop to get the result.
		*/
        List<SummerRunnable> summers =  new ArrayList<>();
        List<WorkPartitioner.Part> parts =  WorkPartitioner.partitions(data.length, threadCount);

        for (WorkPartitioner.Part part : parts) {
            summers.add(new SummerRunnable(data,part));
        }

        for (SummerRunnable SummerRunnable : summers) {
            SummerRunnable.startThread();
        }

        for (SummerRunnable SummerRunnable : summers) {
            try {
                SummerRunnable.joinThread();
            } catch (InterruptedException e) {
                System.err.println("Thread cannot join!");
            }
        }

        long sum = 0;
        for (SummerRunnable summerRunnable : summers) {
            sum += summerRunnable.getSum();
        }
        System.out.println("summer1 " + sum);
        return sum;

    }


}
