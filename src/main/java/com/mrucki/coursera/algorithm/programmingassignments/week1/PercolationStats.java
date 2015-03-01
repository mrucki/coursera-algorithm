package com.mrucki.coursera.algorithm.programmingassignments.week1;

import com.coursera.lib.stdlib.StdStats;

import java.util.Random;

/**
 * Created by Marek_Rucki on 2/10/2015.
 */
public class PercolationStats {
    private Random random = new Random();

    private double[] experiments;

    // perform T independent experiments on an N-by-N grid
    public PercolationStats(int N, int T) {
        if (N <= 0 || T <= 0) {
            throw new java.lang.IllegalArgumentException();
        }

        experiments = new double[T];

        for(int t = 0; t < T ; t++) {
            Percolation percolation = new Percolation(N);

            int opens = 0;
            while (!percolation.percolates()) {
                int i = random.nextInt(N) + 1;
                int j = random.nextInt(N) + 1;

                if (!percolation.isOpen(i, j)) {
                    percolation.open(i, j);
                }

                opens++;
            }

            experiments[t] = opens/(N*N);
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(experiments);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(experiments);
    }

    // low  endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean()-((1.96*stddev())/Math.sqrt(experiments.length));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean()+((1.96*stddev())/Math.sqrt(experiments.length));
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);

        PercolationStats percolationStats = new PercolationStats(N, T);

        System.out.println("mean                    = "+percolationStats.mean());
        System.out.println("stddev                  = "+percolationStats.stddev());
        System.out.println("95% confidence interval = "+percolationStats.confidenceLo()+", "+percolationStats.confidenceHi());
    }
}