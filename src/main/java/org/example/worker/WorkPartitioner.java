package org.example.worker;

import java.util.ArrayList;
import java.util.List;

/*
The WorkPartitioner class is responsible for creating partitions from the data array.
These partitions are then used by multiple threads to process the data and obtain the final result.
 */
public class WorkPartitioner {

    public static List<Part> partitions(int size, int workerCount){
        List<Part> parts =  new ArrayList<>();
        int part = (int) Math.ceil( (double)size / workerCount);
        for (int i = 0; i <workerCount ; i++) {
            int start = i * part;
            int finish = Math.min( (i+1) * part, size);
            parts.add(new Part(start, finish));
        }
        return parts;
    }

    public static class Part {
        private final int start;
        private final int finish;
        public Part(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
        public int getStart() {
            return start;
        }
        public int getFinish() {
            return finish;
        }
    }
}
