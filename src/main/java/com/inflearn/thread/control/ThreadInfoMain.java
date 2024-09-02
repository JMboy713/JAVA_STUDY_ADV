package com.inflearn.thread.control;

import com.inflearn.thread.start.HelloRunnable;

import static com.inflearn.util.MyLogger.log;

public class ThreadInfoMain {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        log("main thread name: " + mainThread.getName());
        log("main thread id: " + mainThread.getId());
        log("main thread state: " + mainThread.getState());
        log("main thread group: " + mainThread.getThreadGroup());
        log("main thread priority: " + mainThread.getPriority());

        Thread thread = new Thread(new HelloRunnable(), "helloRunnable");
        log("thread name: " + thread.getName());
        log("thread id: " + thread.getId());
        log("thread state: " + thread.getState());
        log("thread group: " + thread.getThreadGroup());
        log("thread priority: " + thread.getPriority());
    }
}
