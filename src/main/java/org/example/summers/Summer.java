package org.example.summers;

import org.example.worker.Worker;
import org.example.worker.WorkPartitioner.Part;

import java.util.ArrayList;
import java.util.List;

/*
The Summer class is where the primary functions are established.
These functions will be utilized in the future.
*/
public class Summer extends Worker {
    protected long sum;


    public List<Integer> getPrimes() {
        return primes;
    }

    private List<Integer> primes = new ArrayList<>();
    public Summer(int[] data, Part part) {
        super(data, part);
    }
    public long getSum() {
        return sum;
    }

}
