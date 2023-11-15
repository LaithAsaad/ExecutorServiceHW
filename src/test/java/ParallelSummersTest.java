

import static org.junit.jupiter.api.Assertions.*;

import org.example.SequentialSummer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.example.data.TestData;
import org.example.parallelsummers.ParallelSummer0;
import org.example.parallelsummers.ParallelSummer1;
import org.example.parallelsummers.ParallelSummer2;
import org.example.parallelsummers.ParallelSummer3;
import org.example.parallelsummers.ParallelSummer4;

import java.util.Arrays;
import java.util.List;

class ParallelSummersTest {
    /*
    The ParallelSummersTest class is designed to assess the performance of other classes
     that compute the count of prime numbers within a specified range.
     The range starts from a variable named start and ends at a variable named end.
     The data array contains the numbers within this range,
     and the result variable stores the count of prime numbers calculated sequentially
     */

    private static int start;

    private static int end;
    private static int[] data;
    private static long result;
    /*
    The function initialize is designed to identify the range and sequentially compute the result.
     */
    @BeforeAll
    public static void initialize() {
        start = 0;
        end = 20;
        data = TestData.createData(start, end);
        result = SequentialSummer.sum(SequentialSummer.allPrimes(data));
    }
    /*
    The testAll function is designed to compare the results of calculating the number of primes with five different parallel methods.
    Each method requires a data array that contains a range of numbers and the number of threads to be used.
    */
    private static void testAll(int threadCount) {
        assertEquals(result, ParallelSummer0.sum(data, threadCount));
        assertEquals(result, ParallelSummer1.sum(data, threadCount));
        assertEquals(result, ParallelSummer2.sum(data, threadCount));
        assertEquals(result, ParallelSummer3.sum(data, threadCount));
        assertEquals(result, ParallelSummer4.sum(data, threadCount));
        System.out.println(result);
    }
    /*
    Invoke the testSingleThread function to call the testAll function using a single thread,
    and then print the total duration in seconds it takes to execute the tasks in parallel.
    */
    @Test
    void testSingleThread() {
        long start = System.currentTimeMillis();
        testAll(1);
        long end = System.currentTimeMillis();
        System.out.println("1 Thread takes " + (end-start)/1000 + " seconds");
    }
    /*
    Invoke the testTwoThread function to call the testAll function using two threads,
    and then print the total duration in seconds it takes to execute the tasks in parallel.
    */
    @Test
    void testTwoThread() {
        long start = System.currentTimeMillis();
        testAll(2);
        long end = System.currentTimeMillis();
        System.out.println("2 Threads take " + (end-start)/1000 + " seconds");
    }
    /*
    Invoke the testFourThread function to call the testAll function using four threads,
    and then print the total duration in seconds it takes to execute the tasks in parallel.
    */
    @Test
    void testFourThread() {
        long start = System.currentTimeMillis();
        testAll(4);
        long end = System.currentTimeMillis();
        System.out.println("4 Threads take " + (end-start)/1000 + " seconds");
    }
    /*
    Invoke the testEightThread function to call the testAll function using eight threads,
    and then print the total duration in seconds it takes to execute the tasks in parallel.
    */
    @Test
    void testEightThread() {
        long start = System.currentTimeMillis();
        testAll(8);
        long end = System.currentTimeMillis();
        System.out.println("8 Threads take " + (end-start)/1000 + " seconds");
    }
    /*
    Invoke the testSixteenThread function to call the testAll function using sixteen threads,
    and then print the total duration in seconds it takes to execute the tasks in parallel.
    */
    @Test
    void testSixteenThread() {
        long start = System.currentTimeMillis();
        testAll(16);
        long end = System.currentTimeMillis();
        System.out.println("16 Threads take " + (end-start)/1000 + " seconds");
    }


}
