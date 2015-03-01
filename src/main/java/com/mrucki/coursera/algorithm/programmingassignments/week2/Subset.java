package com.mrucki.coursera.algorithm.programmingassignments.week2;

import com.coursera.lib.stdlib.StdIn;
import com.coursera.lib.stdlib.StdOut;

/**
 * Created by mrucki on 01.03.15.
 */
public class Subset {
    public static void main(String[] args) {
        RandomizedQueue<String> rq = new RandomizedQueue<String>();

        while (!StdIn.isEmpty()) {
            rq.enqueue(StdIn.readString());
        }

        int k = Integer.parseInt(args[0]);
        for (int i = 0; i < k; i++) {
            StdOut.println(rq.dequeue());
        }
    }
}
