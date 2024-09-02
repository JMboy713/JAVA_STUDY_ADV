package com.inflearn.thread.volatile1;

import static com.inflearn.util.MyLogger.log;
import static com.inflearn.util.ThreadUtils.sleep;

public class VolatileFlagMain {
    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask, "work");
        log("runFlag = " + myTask.runFlag);
        thread.start();
        sleep(1000);
        log("runFlag false 로 변경 시도");
        myTask.runFlag = false;
        log("runFlag = " + myTask.runFlag);
    }

    static class MyTask implements Runnable{
        //        boolean runFlag = true;
        volatile boolean runFlag = true;

        @Override
        public void run() {
            log("태스크 시작");
            while (runFlag) {
                // runFlag 가 false 로 변하면 탈출
            }
            log("task 종료");
        }
    }
}
