package com.inflearn.thread.start;

import static com.inflearn.util.MyLogger.log;

public class InnerRunnableMainV4 {
    public static void main(String[] args) {
        log("main start");
        Thread thread = new Thread(() -> log("srun()"));
        thread.start();
        log("main end");
    }


}
