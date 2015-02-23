package com.mrucki.coursera.algorithm.sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class IncorrectComprareTest {

    @Test
    public void testCompareTo() throws Exception {
        IncorrectComprare x = new IncorrectComprare(0.3);
        IncorrectComprare y = new IncorrectComprare(0.4);
        IncorrectComprare z = new IncorrectComprare(0.5);

        assertEquals(-1, x.compareTo(y));
//        assertEquals(-1, y.compareTo(z)); // failed-
        assertEquals(-1, x.compareTo(z));
    }
}