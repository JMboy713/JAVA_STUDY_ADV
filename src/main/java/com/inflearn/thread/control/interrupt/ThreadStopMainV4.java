package com.inflearn.thread.control.interrupt;

import static com.inflearn.util.MyLogger.log;
import static com.inflearn.util.ThreadUtils.sleep;

public class ThreadStopMainV4 {
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

            while (!Thread.interrupted()){ // 확인 후 false 상태로 변경 인터럽트되면 false로 변경
                log("작업중");
            }
            try{
                log("자원 정리 시도");
                Thread.sleep(3000);
                log("자원 정리 완료");
            }catch (InterruptedException e){
                log("자원 정리 실패");
                log("work 스레드 인터럽트 상태 3 = " + Thread.currentThread().isInterrupted());
            }

            log("작업 종료");

        }
    }
}
