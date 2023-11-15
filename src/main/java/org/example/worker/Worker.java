package org.example.worker;

import org.example.worker.WorkPartitioner.Part;

/*
The Worker class is an abstract class that defines the boundaries of a range.
It also contains an array that ( will ) hold the numbers within this range.
*/
public abstract class Worker {

    protected final int start;
    protected final int finish;
    protected final int[] data;

    public Worker(int[] data, int start, int finish) {
        this.start = start;
        this.finish = finish;
        this.data = data;
    }

    public Worker(int[] data, Part part) {
        this(data, part.getStart(), part.getFinish());
    }

    public int getStart() {
        return start;
    }

    public int getFinish() {
        return finish;
    }

    public int[] getData() {
        return data;
    }


}
