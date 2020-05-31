package com.java.algorithm.stackqueuebag;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.ThreeSum;

/**
 * @program: algorithm
 * @author: liumq
 * @create: 2020-05-31 15:38
 **/
public class DoublingTest {
    public static void main(String[] args) {
        for (int N = 250; true; N += N) {
            double time = timeTrial(N);
            System.out.printf("%7d %5.1f\n", N, time);
        }
    }

    public static double timeTrial(int N) {
        int MAX = 1000000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(-MAX, MAX);
        }
        Stopwatch timer = new Stopwatch();
        int cnt = ThreeSum.count(a);
        return timer.elapsedTime();

    }
}
