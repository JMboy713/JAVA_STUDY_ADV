package com.inflearn.thread.control.join;

import static com.inflearn.util.MyLogger.log;

public class JoinMainV3 {
    public static void main(String[] args) throws InterruptedException {
        log("start");
        SumTask task1 = new SumTask(1,50);
        SumTask task2 = new SumTask(51,100);
        Thread thread1 = new Thread(task1, "thread1");
        Thread thread2 = new Thread(task2, "thread2");

        thread1.start();
        thread2.start();
        log("join() - main스레드가 thread1,thread2 종료까지 대기");
        thread1.join(1000);
        thread2.join();

        log("thread1 state = " + task1.result);
        log("thread2 state = " + task2.result);
        int sum = task1.result + task2.result;
        log(sum);

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

