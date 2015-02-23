package com.mrucki.coursera.algorithm.programmingassignments;

import com.coursera.lib.algs4.WeightedQuickUnionUF;

/**
 * Created by Marek_Rucki on 2/9/2015.
 */
public class Percolation {
    private WeightedQuickUnionUF weightedQuickUnionUF;
    private int size;
    private boolean[][] grid;

    // create N-by-N grid, with all sites blocked
    public Percolation(int size) {
        if(size <= 0) {
            throw new IllegalArgumentException();
        }

        this.size = size;
        grid = new boolean[size][size];
        weightedQuickUnionUF = new WeightedQuickUnionUF(size*size);
    }

    // open site (row i, column j) if it is not open already
    public void open(int i, int j) {
        grid[i-1][j-1] = true;

        int currentId = computeId(i, j);

        int iLeft = i;
        int jLeft = j-1;
        if(j > 1 && isOpen(iLeft, jLeft)) { // left
            weightedQuickUnionUF.union(currentId-1, computeId(iLeft, jLeft)-1);
        }

        int iTop = i-1;
        int jTop = j;
        if(i > 1 && isOpen(iTop, jTop)) { // top
            weightedQuickUnionUF.union(currentId-1, computeId(iTop, jTop)-1);
        }

        int iRight = i;
        int jRight = j+1;
        if(j < size && isOpen(iRight, jRight)) { // right
            weightedQuickUnionUF.union(currentId-1, computeId(iRight, jRight)-1);
        }

        int iBottom = i+1;
        int jBottom = j;
        if(i > size && isOpen(iBottom, jBottom)) { // bottom
            weightedQuickUnionUF.union(currentId-1, computeId(iBottom, jBottom)-1);
        }
    }

    private int computeId(int i, int j) {
        return size * (i - 1) + j;
    }

    // is site (row i, column j) open?
    public boolean isOpen(int i, int j) {
        return grid[i-1][j-1];
    }

    // is site (row i, column j) full?
    public boolean isFull(int i, int j) {
        boolean isFull = false;

        int currentId = computeId(i, j);

        int iLeft = i;
        int jLeft = j-1;
        if(j > 1 && isOpen(iLeft, jLeft)) { // left
            isFull = isFull | weightedQuickUnionUF.connected(currentId - 1, computeId(iLeft, jLeft) - 1);
        }

        int iTop = i-1;
        int jTop = j;
        if(i > 1 && isOpen(iTop, jTop)) { // top
            isFull = isFull | weightedQuickUnionUF.connected(currentId - 1, computeId(iTop, jTop) - 1);
        }

        int iRight = i;
        int jRight = j+1;
        if(j < size && isOpen(iRight, jRight)) { // right
            isFull = isFull | weightedQuickUnionUF.connected(currentId - 1, computeId(iRight, jRight) - 1);
        }

        int iBottom = i+1;
        int jBottom = j;
        if(i > size && isOpen(iBottom, jBottom)) { // bottom
            isFull = isFull | weightedQuickUnionUF.connected(currentId-1, computeId(iBottom, jBottom)-1);
        }

        return isFull;
    }

    // does the system percolate?
    public boolean percolates() {
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                int cur = computeId(i, j);
                if (isOpen(1, i) && isOpen(size, j) && weightedQuickUnionUF.connected(i-1, cur-1)) {
                    return true;
                }
            }
        }

        return false;
    }
}
