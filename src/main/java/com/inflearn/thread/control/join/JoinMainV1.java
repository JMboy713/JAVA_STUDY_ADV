package com.inflearn.thread.control.join;

import static com.inflearn.util.MyLogger.log;

public class JoinMainV1 {
    public static void main(String[] args) {
        log("start");
        SumTask task1 = new SumTask(1,50);
        SumTask task2 = new SumTask(51,100);
        Thread thread1 = new Thread(task1, "thread1");
        Thread thread2 = new Thread(task2, "thread2");

        thread1.start();
        thread2.start();

        log("thread1 state = " + task1.result);
        log("thread2 state = " + task2.result);
        int sum = task1.result + task2.result;
        System.out.println("end");
    }

    private static class SumTask implements Runnable{
        int startValue;
        int endValue;
        int result = 0;

        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public void run() {
            log("start");
            int sum = 0;
            for (int i = startValue; i <= endValue; i++) {
                sum += i;
            }
            result = sum;
            log("sum = " + sum);
            log("end");
        }
    }
}
