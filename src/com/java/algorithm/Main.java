package com.java.algorithm;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Main {

    public static void main(String[] args) {

        testStack();
    }

    private static void StdRandom(String[] args) {
        int N = Integer.parseInt(args[0]);
        double lo=Double.parseDouble(args[1]);
        double hi = Double.parseDouble(args[2]);

        for(int i =0;i<N;i++)
        {
            double current = StdRandom.uniform(lo,hi);
            StdOut.printf("%.2f\n",current);
        }
    }

    private static void testStack()
    {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        for(Integer i : stack)
        {
            System.out.println(i);
        }
    }
}
