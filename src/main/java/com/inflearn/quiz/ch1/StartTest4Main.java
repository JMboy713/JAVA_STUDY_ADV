package com.inflearn.quiz.ch1;

import com.inflearn.util.MyLogger;

import static com.inflearn.util.MyLogger.*;

public class StartTest4Main {
    public static void main(String[] args) {

        mySolution();
        yhSolution();
    }

    private static void yhSolution() {
        Thread threadA = new Thread(new PrintWork("A",1000),"Thread-A");
        Thread threadB = new Thread(new PrintWork("B",1000),"Thread-B");
    }

    private static void mySolution() {
        Thread threadA = new Thread(() -> {
            while (true) {
                log(Thread.currentThread().getName().substring(6));
                try{
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"Thread-A");
        Thread threadB = new Thread(() -> {
            while (true) {
                log(Thread.currentThread().getName().substring(6));
                try{
                    Thread.sleep(500);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"Thread-B");
        threadB.start();
        threadA.start();
    }

    static class PrintWork implements Runnable{
        private String content;
        private int sleepMs;

        public PrintWork(String content, int sleepMs) {
            this.content = content;
            this.sleepMs = sleepMs;
        }

        @Override
        public void run() {
            while (true) {
                log(content);
                try {
                    Thread.sleep(sleepMs);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
