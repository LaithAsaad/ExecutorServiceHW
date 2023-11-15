package org.example.summers;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import org.example.worker.Worker;
import org.example.worker.WorkPartitioner.Part;

/*
The SummerCallable class is a child of the Summer class and implements the Callable interface.
This class includes a call function that computes the count of prime numbers.
*/
public class SummerCallable extends Summer implements Callable<Long> {

    public SummerCallable(int[] data, Part part) {
        super(data, part);
    }

    @Override
    public Long call() throws Exception {
        this.sum = 0;
        List<Integer> primes = new ArrayList<>();
        for (int i = start; i < finish; i++) {
            if (isPrime(data[i])) {
                primes.add(data[i]);
                sum ++;
            }
        }
        return sum;
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