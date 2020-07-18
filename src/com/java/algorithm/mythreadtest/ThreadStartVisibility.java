package com.java.algorithm.mythreadtest;

/**
 * 线程启动与可见性
 */
public class ThreadStartVisibility {
    static int data=0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(data);
            }
        };

        //在子线程启动之前更新data 的值为1
        data =1;
        thread.start();

        Thread.sleep(50);
        //在子线程启动之后更新变量data 的值
        data=2;
    }
}
