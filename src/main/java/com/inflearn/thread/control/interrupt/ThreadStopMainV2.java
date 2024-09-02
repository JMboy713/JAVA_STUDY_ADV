package com.inflearn.thread.control.interrupt;

import static com.inflearn.util.MyLogger.log;
import static com.inflearn.util.ThreadUtils.sleep;

public class ThreadStopMainV2 {
    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask, "work");
        thread.start();
        sleep(4000);
        log("작업 중단 지시 Thread.interrupt");
        thread.interrupt();

        log("work 스레드 인터럽트 상태 1 = " + thread.isInterrupted());
    }

    private static class MyTask implements Runnable{
//        volatile boolean runFlag = true;
        @Override
        public void run() {
            try{
                while (true){
                    log("작업중");
                    Thread.sleep(3000);
                }
            }catch (InterruptedException e){
                log("work 스레드 인터럽트 상태 2 = " + Thread.currentThread().isInterrupted());
            }
            log("자원정리");
            log("작업 종료");

        }
    }
}
