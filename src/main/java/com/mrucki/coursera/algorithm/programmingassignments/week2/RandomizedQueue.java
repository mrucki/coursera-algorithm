package com.mrucki.coursera.algorithm.programmingassignments.week2;

import com.coursera.lib.stdlib.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by mrucki on 27.02.15.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    private static final int INITIAL_SIZE = 16;
    private Item[] items;
    private int size;

    @SuppressWarnings("unchecked")
    public RandomizedQueue() {
        items = (Item[]) new Object[INITIAL_SIZE];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {
        if(item == null) {
            throw new NullPointerException();
        }

        if(size == items.length) {
            resize();
        }

        items[size] = item;

        size++;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        Item[] newItems = (Item[]) new Object[items.length*2];
        System.arraycopy(items, 0, newItems, 0, items.length);
        items = newItems;
    }

    public Item dequeue() {
        validateIfEmpty();

        int lastIndex = getLastIndex();
        int index = createRandomIndex();

        Item selectedItem = items[index];
        items[index] = items[lastIndex];
        items[lastIndex] = null;

        size--;

        if(items.length > INITIAL_SIZE && size*2 == items.length) {
            Item[] newItems = (Item[]) new Object[size];
            System.arraycopy(items, 0, newItems, 0, newItems.length);
            items = newItems;
        }

        return selectedItem;
    }

    private int createRandomIndex() {
        return size > 0 ? StdRandom.uniform(size) : 0;
    }

    public Item sample() {
        validateIfEmpty();
        int index = createRandomIndex();
        return items[index];
    }

    private int getLastIndex() {
        return isEmpty() ? size : size-1;
    }

    private void validateIfEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
    }

    public Iterator<Item> iterator() {
        return new RandomizedIterator();
    }

    private class RandomizedIterator implements Iterator<Item> {

        private int current = 0;
        private Integer[] randomIndexes;

        public RandomizedIterator() {
            randomIndexes = new Integer[size];
            for (int i = 0; i < size; i++) {
                randomIndexes[i] = i;
            }
            StdRandom.shuffle(randomIndexes);
        }

        @Override
        public boolean hasNext() {
            return current < randomIndexes.length;
        }

        @Override
        public Item next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            int index = randomIndexes[current];
            Item next = items[index];
            current++;

            return next;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
