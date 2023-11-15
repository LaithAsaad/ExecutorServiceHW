package org.example.data;
/*
The TestData class is responsible for generating an array of data based on the specified range.
*/
public class TestData {

    public static int[] createData(int start, int end) {
        int[] data =  new int[end - start + 1];
        for (int i = 0; i < data.length; i++) {
            data[i] = start + i;
        }
        return data;
    }
}
