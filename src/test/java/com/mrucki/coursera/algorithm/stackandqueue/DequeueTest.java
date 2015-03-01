package com.mrucki.coursera.algorithm.stackandqueue;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class DequeueTest {

    @Test
    public void testAddFirst() throws Exception {
        Deque<Integer> cut = new Deque<Integer>();
        cut.addFirst(1);
        cut.addFirst(2);
        cut.addFirst(3);
        cut.addFirst(4);

        assertEquals(4, cut.size());

        assertEquals(new Integer(4), cut.removeFirst());
        assertEquals(new Integer(3), cut.removeFirst());
        assertEquals(new Integer(2), cut.removeFirst());
        assertEquals(new Integer(1), cut.removeFirst());
        assertTrue(cut.isEmpty());
    }

    @Test
    public void testAddLast() throws Exception {
        Deque<Integer> cut = new Deque<Integer>();
        cut.addLast(1);
        cut.addLast(2);
        cut.addLast(3);
        cut.addLast(4);

        assertEquals(4, cut.size());

        assertEquals(new Integer(4), cut.removeLast());
        assertEquals(new Integer(3), cut.removeLast());
        assertEquals(new Integer(2), cut.removeLast());
        assertEquals(new Integer(1), cut.removeLast());
        assertTrue(cut.isEmpty());
    }

    @Test
    public void testIterator() throws Exception {
        Deque<Integer> cut = new Deque<Integer>();
        cut.addFirst(1);
        cut.addFirst(2);
        cut.addFirst(3);
        cut.addFirst(4);

        cut.addLast(1);
        cut.addLast(2);
        cut.addLast(3);
        cut.addLast(4);

        Iterator<Integer> dequeueIterator = cut.iterator();
        String result = "";
        while(dequeueIterator.hasNext()) {
            Integer item = dequeueIterator.next();
            result+= item;
        }

        assertEquals("43211234", result);
    }
}