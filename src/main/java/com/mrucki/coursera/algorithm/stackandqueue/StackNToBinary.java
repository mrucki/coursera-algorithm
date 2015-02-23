package com.mrucki.coursera.algorithm.stackandqueue;

import java.util.Stack;

/**
 * Created by Marek_Rucki on 2/5/2015.
 */
public class StackNToBinary {
    public static void main(String[] args) {
        int n = 50;

        Stack<Integer> stack = new Stack<Integer>();
        while (n > 0) {
            stack.push(n % 2);
            n = n / 2;
        }

        for (int d : stack) {
            System.out.print(d);
        }
    }
}
