package com.java.algorithm;

/**
 * @program: algorithm
 * @author: liumq
 * @create: 2020-05-10 10:12
 **/
public class FunctionTest {

    public Integer threadFunction(Integer sleep) throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(sleep * 1000);
        System.out.println("current cost" + (System.currentTimeMillis() - start));
        return sleep;
    }
}
