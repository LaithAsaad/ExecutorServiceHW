package org.example.summers;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.example.worker.WorkPartitioner.Part;

/*
The SummerThread class is a child of the Thread class.
This class includes a run function that computes the count of prime numbers.
*/
public class SummerThread extends Thread{
    private int start;
    private int finish;
    private int[] data;
    private long sum;


    private List<Integer> primes = new ArrayList<>();
    public SummerThread(int[] data, int start, int finish) {
        this.start = start;
        this.finish = finish;
        this.data = data;
    }

    public SummerThread(int[] data, Part part) {
        this(data, part.getStart(), part.getFinish());
    }

    @Override
    public void run() {
        sum = 0;
        for (int i = start; i < finish; i++) {
            if (isPrime(data[i])) {
                primes.add(data[i]);
                sum++;
            }
        }
    }

    public long getSum() {
        return sum;
    }
    public List<Integer> getPrimes() {
        return primes;
    }
    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i*i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}