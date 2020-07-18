package com.java.algorithm.mythreadtest;

public class VilibilityDemo {
    public static void main(String[] args) throws InterruptedException {
        TimeConsumingTask timeConsumingTask = new TimeConsumingTask();
        Thread thread = new Thread(new TimeConsumingTask());
        thread.start();

        Thread.sleep(10000);
        timeConsumingTask.cancel();

    }


}

class TimeConsumingTask implements Runnable {

    private boolean toCancel = false;

    @Override
    public void run() {
        while (!toCancel) {
            try {
                if (doExcute()) {
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (toCancel) {
            System.out.println("Task is canceled.");
        } else {
            System.out.println("Task is done.");
        }
    }

    private boolean doExcute() throws InterruptedException {
        boolean isDone = false;
        System.out.println("excuting ------");

        Thread.sleep(50);

        return isDone;
    }

    public void cancel() {
        toCancel = true;
        System.out.println(this + "canceled...");
    }
}
