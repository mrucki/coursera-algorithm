package com.mrucki.coursera.algorithm.stackandqueue;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Marek_Rucki on 2/23/2015.
 */
public class Deque<Item> implements Iterable<Item> {

    LinkedList<Item> elements = new LinkedList<Item>();

    public Deque() {
    }

    public boolean isEmpty() {
        return false;
    }

    public int size() {
        return 0;
    }

    public void addFirst(Item item) {
        validate(item);
    }

    private void validate(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
    }

    public void addLast(Item item) {
        validate(item);
    }

    public Item removeFirst() {
        return null;
    }
    public Item removeLast() {
        return null;
    }
    public Iterator<Item> iterator() {
        return null;
    }

    public static void main(String[] args) {

    }
}
