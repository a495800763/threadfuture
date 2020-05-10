package com.java.algorithm;

import java.util.*;
import java.util.concurrent.CompletableFuture;

/**
 * @program: algorithm
 * @author: liumq
 * @create: 2020-05-10 10:11
 **/
public class futureTest {

    public Object getStudentInfoWithCompletableFuture() {
        System.out.println("currentTime:"+new Date());
        List<Integer> result = new ArrayList<>();
        long start = System.currentTimeMillis();
        CompletableFuture[] futures = new CompletableFuture[10];
        try {
            for (int i = 0; i <= 9; i++) {
                int finalI = i + 1;
                CompletableFuture currentFuture = CompletableFuture.supplyAsync(() -> {
                    try {
                        return new FunctionTest().threadFunction(finalI);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return null;

                });
                futures[i] = currentFuture;
            }
            CompletableFuture.allOf(futures).join();
            for (CompletableFuture item : futures) {
                result.add((Integer) item.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("total cost" + (System.currentTimeMillis() - start));
        System.out.println("currentTime:"+new Date());
        return result;
    }
    public static void main(String[] args) {
        Object studentInfoWithCompletableFuture = new futureTest().getStudentInfoWithCompletableFuture();
        System.out.println(studentInfoWithCompletableFuture.toString());
    }
}
