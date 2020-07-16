package com.java.algorithm.mythreadtest;

public class RaceConditionDemo {
    public static void main(String[] args) {
        //客户端线程数
        int numberOfThreads = args.length > 0 ? Short.valueOf(args[0]) : Runtime.getRuntime().availableProcessors();
        Thread[] worksThreads = new Thread[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            worksThreads[i] = new WorkerThread(i, 20);
        }

        for (Thread ct : worksThreads) {
            ct.start();
        }
    }


    static class WorkerThread extends Thread {
        private final int requestCount;

        public WorkerThread(int id, int requestCount) {
            super("worker-" + id);
            this.requestCount = requestCount;
        }

        @Override
        public void run() {
            int i = requestCount;
            String requestID;

            RequestIDGenerator requestIDGen = RequestIDGenerator.getInstance();
            while (i-- > 0) {
                requestID = requestIDGen.nextID();
                try {
                    processRequest(requestID);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void processRequest(String requestID) throws InterruptedException {
            Thread.sleep(50);
            System.out.printf("%s got requestID : %s %n", Thread.currentThread().getName(), requestID);
        }
    }
}
