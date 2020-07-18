package com.java.algorithm.mythreadtest;

public class ThreadTest {
    public static void main(String[] args) {
        Thread t = new Thread();
        Thread.State state = t.getState();
        System.out.println(state);
        System.out.println("刘梦后期是");
    }
}
