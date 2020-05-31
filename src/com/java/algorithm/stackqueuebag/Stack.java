package com.java.algorithm.stackqueuebag;

import java.util.Iterator;

/**
 * @program: algorithm
 * @author: liumq
 * @create: 2020-05-31 15:05
 **/
public class Stack<Item> implements Iterable<Item> {

    private Node first;  //栈顶元素 （最近添加的元素）
    private int N;       //栈中元素数量

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

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

    /**
     * 向栈顶添加元素
     *
     * @param item
     */
    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    /**
     * 从栈顶移除元素
     *
     * @return
     */
    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }


    public static void main(String[] args) {
        // todo test
    }


}
