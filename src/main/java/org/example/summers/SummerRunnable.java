package org.example.summers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import org.example.worker.WorkPartitioner.Part;

/*
The SummerRunnable class is a child of the Summer class and implements the Runnable interface.
This class includes a run function that computes the count of prime numbers.
*/
public class SummerRunnable extends Summer implements Runnable{

    private Thread thread;



    private List<Integer> primes = new ArrayList<>();
    public SummerRunnable(int[] data, Part part) {
        super(data, part);
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

    public void startThread() {
        thread =  new Thread(this);
        thread.start();
    }

    public void joinThread() throws InterruptedException {
        thread.join();
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

    @Override
    public List<Integer> getPrimes() {
        return primes;
    }
    public long getSum() {
        return sum;
    }
}