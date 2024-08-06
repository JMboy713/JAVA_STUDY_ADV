package com.inflearn.thread.control.join;

import static com.inflearn.util.MyLogger.log;
import static com.inflearn.util.ThreadUtils.sleep;

public class JoinMainV0 {
    public static void main(String[] args) {
        log("start");
        Thread thread1 = new Thread(new Job(), "thread1");
        Thread thread2 = new Thread(new Job(), "thread2");

        thread1.start();
        thread2.start();
        log("end");
    }

    static class Job implements Runnable{
        @Override
        public void run() {
            log("start");
            sleep(3000);
            log("end");
        }
    }
}
