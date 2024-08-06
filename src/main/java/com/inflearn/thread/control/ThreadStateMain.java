package com.inflearn.thread.control;

import com.inflearn.util.MyLogger;

import static com.inflearn.util.MyLogger.*;

public class ThreadStateMain {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyRunnable(), "MyRunnable");
        log("myThread.state1="+thread.getState());
        log("Thread start");
        thread.start();
        thread.sleep(1000);
        log("myThread.state3="+thread.getState());
        thread.sleep(4000);
        log("myThread.state5="+thread.getState());
        log("Thread end");
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            try{
                log("start");
                log("myThread.state2 = "+Thread.currentThread().getState());
                log("sleep start");
                Thread.sleep(3000);
                log("myThread.state4 = "+Thread.currentThread().getState());
                log("sleep end");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
