package com.inflearn.thread.control;

public class CheckedExceptionMain {
    public static void main(String[] args) throws Exception {
        throw new Exception();
    }
    static class CheckedExceptionThread implements Runnable {
        @Override
        public void run() {
        }
    }
}
