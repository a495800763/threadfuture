package com.java.algorithm.sort;

import edu.princeton.cs.algs4.StdOut;

/**
 * @program: algorithm
 * @author: liumq
 * @create: 2020-06-03 19:03
 **/
public class Example {
    /**
     * 选择排序
     * @param a
     */
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
                exch(a, i, min);
            }
        }
    }

    /**
     * 选择排序
     * @param a
     */
    public static void insertSort (Comparable[] a)
    {
        int N = a.length;
        for(int i =1;i<N;i++)
        {
            for(int j =i;j>0&&less(a[j],a[j-1]);j--)
            {
                exch(a,j,j-1);
            }
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        String[] a = new String[4];
        a[0] = "asd";
        a[1] = "rth";
        a[2] = "ujfg";
        a[3] = "bfvbz";

        insertSort(a);
        assert isSorted(a);
        show(a);
    }

}
