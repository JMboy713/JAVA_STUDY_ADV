package com.inflearn.quiz.ch1;

import com.inflearn.util.MyLogger;

import static com.inflearn.util.MyLogger.*;

public class StartTest2Main {
    public static void main(String[] args) {
        log("main start");
        Thread thread = new Thread(new CounerRunnable(),"counter");
        thread.start();
        log("main end");
    }

    static class CounerRunnable implements Runnable{
        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                log("value :"+i);
                try{
                    Thread.sleep(1000);// 1초간 대기
                }catch (InterruptedException e){
                    throw new RuntimeException(e);
                }

            }
        }
    }

}
