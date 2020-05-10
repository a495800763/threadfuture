package com.java.algorithm;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

/**
 * @program: algorithm
 * @author: liumq
 * @create: 2020-05-09 21:36
 **/
public class TaskTest {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println("currentTime:" + new Date());
        Integer threadNum = 6;
        List<String> result = new ArrayList<>();
        List<String> runResult = new ArrayList<>();
        try {
            runResult = runfun(threadNum, result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // System.out.println("开始执行");
        for (String item : runResult) {
            System.out.println("这是最后的结果:" + item);
        }
        System.out.println("total cost" + (System.currentTimeMillis() - start));
    }

    private static List<String> runfun(Integer threadNum, List<String> result) throws InterruptedException {
        // System.out.println("main函数开始执行");
        ExecutorService executor = Executors.newFixedThreadPool(6);


        for (int i = 0; i < threadNum; i++) {

            int finalI = i;
            CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(1000 * finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                result.add(Thread.currentThread().getName().toString());
                return Thread.currentThread().getName().toString();
            }, executor);

            //回调函数 在完成后打印当前的数组值，可以看到数组中的值确实增加了

             future.thenAccept(e -> System.out.println("accept:" + result.toString()));
             future.thenAcceptAsync(e -> System.out.println("AcceptAsync" + result.toString()));
            future.thenRun(new testRunnbale());
            while (true) {
                //在主线程中一直轮询是否执行完 可以起到阻塞主线程的作用
                if (future.isDone()) {
                    System.out.println("我在做别的事情");
                    break;
                }

            }
        }

        return result;
    }


    static class testRunnbale implements Runnable {

        @Override
        public void run() {
            System.out.println("开始执行runnble");
        }
    }


}
