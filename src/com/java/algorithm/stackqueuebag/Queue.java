package com.java.algorithm.stackqueuebag;

import java.nio.file.FileStore;
import java.util.Iterator;

/**
 * @program: algorithm
 * @author: liumq
 * @create: 2020-05-31 15:12
 **/
public class Queue<Item> implements Iterable<Item> {

    private Node first;  //指向最早添加的结点（头节点）的链接
    private Node last;   //指向最近添加的结点（尾结点）的链接
    private int N;

    //定义了结点的内部类
    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }


    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        N++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private Node current = first;


        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }


        @Override
        public void remove() {
        }
    }
}
