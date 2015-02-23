package com.mrucki.coursera.algorithm.unionfind;

import com.mrucki.coursera.algorithm.unionfind.QuickFindUF;
import org.junit.Assert;
import org.junit.Test;

public class QuickFindUFTest {

    @Test
    public void testUnion() throws Exception {
        QuickFindUF cut = new QuickFindUF(10);
        cut.union(2, 9);
        cut.union(2, 4);
        cut.union(8, 7);
        cut.union(0, 8);
        cut.union(6, 8);
        cut.union(4, 1);

        String expected = "7 1 1 3 1 5 7 7 7 1";

        System.out.println("index:    0 1 2 3 4 5 6 7 8 9");
        System.out.println("          - - - - - - - - - -");
        System.out.println("expected: "+expected);
        System.out.println("cut ids:  "+cut.getIds());

        Assert.assertEquals(expected, cut.getIds());
    }
}