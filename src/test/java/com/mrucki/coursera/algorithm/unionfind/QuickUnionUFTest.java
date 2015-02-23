package com.mrucki.coursera.algorithm.unionfind;

import com.mrucki.coursera.algorithm.unionfind.QuickUnionUF;
import org.junit.Assert;
import org.junit.Test;

public class QuickUnionUFTest {
    @Test
    public void test() throws Exception {
        QuickUnionUF cut = new QuickUnionUF(10);
        cut.union(6, 2);
        cut.union(6, 9);
        cut.union(7, 1);
        cut.union(2, 5);
        cut.union(2, 3);
        cut.union(0, 4);
        cut.union(7, 0);
        cut.union(7, 9);
        cut.union(8, 9);

        String expected = "4 4 9 3 3 3 2 1 3 5";

        System.out.println("index:    0 1 2 3 4 5 6 7 8 9");
        System.out.println("          - - - - - - - - - -");
        System.out.println("expected: "+expected);
        System.out.println("cut ids:  "+cut.getIds());

        Assert.assertEquals(expected, cut.getIds());
    }
}