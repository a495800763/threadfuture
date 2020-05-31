package com.java.algorithm;

import edu.princeton.cs.algs4.*;

/**
 * @program: algorithm
 * @author: liumq
 * @create: 2020-05-29 23:06
 **/
public class Interval {
    public static void main(String[] args) {
        double xlo = Double.parseDouble(".2");
        double xhi = Double.parseDouble(".5");
        double ylo = Double.parseDouble(".5");
        double yhi = Double.parseDouble(".6");
        int T = Integer.parseInt("10000297");

        Interval1D xinterval = new Interval1D(xlo, xhi);
        Interval1D yinterval = new Interval1D(ylo, yhi);
        Interval2D box = new Interval2D(xinterval, yinterval);
        box.draw();


        Counter c = new Counter("this");
        for (int t = 0; t < T; t++) {
            double x = Math.random();
            double y = Math.random();
            Point2D p = new Point2D(x, y);
            if (box.contains(p)) {
                c.increment();
            } else {
                p.draw();
            }
        }

        StdOut.println(c);
        StdOut.println(box.area());

    }
}
