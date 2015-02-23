package com.mrucki.coursera.algorithm.unionfind;

/**
 * Created by Marek_Rucki on 2/4/2015.
 */
public class QuickUnionUF {
    private int[] id;

    public QuickUnionUF(int size) {
        id = new int[size];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);

        id[i] = j;
    }

    private int root(int i) {
        while(i != id[i]) {
            i = id[i];
        }

        return i;
    }

    public String getIds() {
        String result = "";
        for (int i = 0; i < id.length; i++) {
            result += " "+id[i];
        }

        return result.trim();
    }
}
