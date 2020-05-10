package com.java.algorithm;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

/**
 * @program: algorithm
 * @author: liumq
 * @create: 2020-05-10 10:02
 **/
public class WorkThread extends  Thread {
    private final BlockingQueue<Runnable> queue;

    public WorkThread(BlockingQueue<Runnable> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true)
        {
            try {
                Runnable task = queue.take();
                task.run();
            }catch (InterruptedException e)
            {
                break;
            }
        }
    }
}
