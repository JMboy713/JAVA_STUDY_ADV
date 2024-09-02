package com.inflearn.thread.control.interrupt;

import static com.inflearn.util.MyLogger.log;
import static com.inflearn.util.ThreadUtils.sleep;

public class ThreadStopMainV1 {
    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask, "work");
        thread.start();
        sleep(4000);
        log("작업 중단 지시 runflag = false");
        myTask.runFlag = false;
    }

    private static class MyTask implements Runnable{
        volatile boolean runFlag = true;
        @Override
        public void run() {
            while (runFlag){
                log("작업중");
                sleep(3000);
            }
            log("자원정리");
            log("작업 종료");


        }
    }
}
