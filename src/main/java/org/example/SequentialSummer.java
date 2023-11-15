package org.example;

import java.util.ArrayList;
import java.util.List;
/*
The SequentialSummer class calculate the number of primes sequentially.
*/
public class SequentialSummer {

    public static long sum(List<Integer> data) {
        long sum = data.size();
        return sum;
    }
    /*
    The allPrimes function find all primes in the data array sequentially using isPrime function.
    */
    public static List<Integer> allPrimes(int[] data)
    {
        List<Integer> primes = new ArrayList<>();
        for (int i = data[0]; i <= data[data.length -1]; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
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
