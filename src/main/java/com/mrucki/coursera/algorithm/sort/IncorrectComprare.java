package com.mrucki.coursera.algorithm.sort;

/**
 * Created by Marek_Rucki on 2/6/2015.
 */
public class IncorrectComprare implements Comparable<IncorrectComprare> {
    private final double deg;

    public IncorrectComprare(double deg) {
        this.deg = deg;
    }

    public int compareTo(IncorrectComprare that) {
        double EPS = 0.1;
        if (this.deg < that.deg - EPS)
            return -1;
        if (this.deg > that.deg + EPS)
            return +1;
        return  0;
    }
}
