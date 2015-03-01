package com.mrucki.coursera.algorithm.programmingassignments.week2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Marek_Rucki on 2/23/2015.
 */
public class Deque<Item> implements Iterable<Item> {

    private Node<Item> first;
    private Node<Item> last;

    private int size;

    public Deque() {
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        validateAdd(item);

        Node<Item> newFirst = new Node<Item>(null, item, first);
        if (first != null) {
            first.previous = newFirst;
        }
        first = newFirst;

        if (last == null) {
            last = newFirst;
        }

        size++;
    }

    public void addLast(Item item) {
        validateAdd(item);

        Node<Item> newLast = new Node<Item>(last, item, null);
        if (last != null) {
            last.next = newLast;
        }
        last = newLast;

        if (first == null) {
            first = newLast;
        }

        size++;
    }

    private void validateAdd(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
    }

    public Item removeFirst() {
        validateRemove();
        Item firstItem = first.current;
        first = first.next;
        size--;

        return firstItem;
    }

    public Item removeLast() {
        validateRemove();
        Item lastItem = last.current;
        last = last.previous;
        size--;

        return lastItem;
    }

    private void validateRemove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
    }

    public Iterator<Item> iterator() {
        return new NodeIterator<Item>(first);
    }

    private class Node<Item> {
        private Node<Item> previous;
        private Item current;
        private Node<Item> next;

        public Node(Node<Item> previous, Item current, Node<Item> next) {
            this.previous = previous;
            this.current = current;
            this.next = next;
        }
    }

    private class NodeIterator<Item> implements Iterator<Item> {

        private Node<Item> current;

        public NodeIterator(Node<Item> current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item nextItem = current.current;
            current = current.next;
            return nextItem;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
