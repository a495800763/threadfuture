package com.java.algorithm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @program: algorithm
 * @author: liumq
 * @create: 2020-05-10 15:11
 **/
public class FutureTestNew {
    public CompletableFuture[] getStudentInfoWithCompletableFuture() {
       // System.out.println("currentTime:"+new Date());
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
            //CompletableFuture.allOf(futures).join();
           // for (CompletableFuture item : futures) {
            //    result.add((Integer) item.get());
          //  }
        } catch (Exception e) {
            e.printStackTrace();
        }
       // System.out.println("total cost" + (System.currentTimeMillis() - start));
      //  System.out.println("currentTime:"+new Date());
        return futures;
    }
    public static void main(String[] args) {
        CompletableFuture[] future = new FutureTestNew().getStudentInfoWithCompletableFuture();
        List<Integer> result = new ArrayList<>();
        try {
            for(CompletableFuture future1 :future)
            {
                while (true)
                {
                    if(future1.isDone())
                    {
                        result.add((Integer) future1.get());
                        break;
                    }

                }
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println(result.toString());
    }
}
