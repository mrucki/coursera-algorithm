package com.mrucki.coursera.algorithm.stackandqueue;

import org.junit.Test;

import java.util.Iterator;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class RandomizedQueueTest {

    public static final int TESTED_SIZE = 100;

    @Test
    public void testEnqueueAndDequeue() throws Exception {
        RandomizedQueue<Integer> cut = createRandomizedQueue(TESTED_SIZE);

        for (int i = 0; i < TESTED_SIZE; i++) {
            Integer randomItem = cut.sample();
            assertTrue(randomItem >= 0);
            assertTrue(randomItem < TESTED_SIZE);
        }

        assertFalse(cut.isEmpty());
        assertEquals(TESTED_SIZE, cut.size());

        for (int i = 0; i < TESTED_SIZE; i++) {
            Integer randomItem = cut.dequeue();
            assertTrue(randomItem >= 0);
            assertTrue(randomItem < TESTED_SIZE);
        }

        assertTrue(cut.isEmpty());
    }

    @Test
    public void testIterator() throws Exception {
        RandomizedQueue<Integer> cut = createRandomizedQueue(TESTED_SIZE);

        TreeSet<Integer> result = new TreeSet<Integer>();

        for (Integer randomItem : cut) {
            assertTrue(randomItem >= 0);
            assertTrue(randomItem < TESTED_SIZE);

            result.add(randomItem);
        }

        int expectedResult = 0;
        for (Integer r : result) {
            assertEquals(expectedResult, r.intValue());
            expectedResult++;
        }
    }

    private RandomizedQueue<Integer> createRandomizedQueue(int testedSize) {
        RandomizedQueue<Integer> cut = new RandomizedQueue<Integer>();
        assertTrue(cut.isEmpty());

        for (int i = 0; i < testedSize; i++) {
            cut.enqueue(i);
        }
        return cut;
    }
}