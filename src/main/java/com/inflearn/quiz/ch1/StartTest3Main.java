package com.inflearn.quiz.ch1;

import com.inflearn.util.MyLogger;

import static com.inflearn.util.MyLogger.log;

public class StartTest3Main {
    public static void main(String[] args) {

        log("start");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 5 ; i++) {
                    log("value : "+i);
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        Thread thread = new Thread(runnable,"counter");
        thread.start();
    }
}
