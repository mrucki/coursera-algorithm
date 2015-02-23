package com.mrucki.coursera.algorithm.unionfind;

/**
 * Created by Marek_Rucki on 1/30/2015.
 */
public class QuickFindUF {
    private int[] id;

    public QuickFindUF(int size) {
        id = new int[size];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    public boolean isConnected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int qid = id[q];
        int pid = id[p];

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }

    public String getIds() {
        String result = "";
        for (int i = 0; i < id.length; i++) {
            result += " "+id[i];
        }

        return result.trim();
    }
}
