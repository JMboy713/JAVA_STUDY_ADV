package com.inflearn.thread.start;

import com.inflearn.util.MyLogger;

import static com.inflearn.util.MyLogger.*;

public class ManyThreadMainV1 {
    public static void main(String[] args) {
        log("main start");
        HelloRunnable runnable = new HelloRunnable();
        Thread thread1 = new Thread(runnable);
        thread1.start();
        Thread thread2 = new Thread(runnable);
        thread2.start();
        Thread thread3 = new Thread(runnable);
        thread3.start();

    }
}
