package com.inflearn.thread.start;

public class HelloRunnableMain {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+" start");
        HelloRunnable helloRunnable = new HelloRunnable();
        System.out.println(Thread.currentThread().getName()+"start 호출전");
        Thread thread = new Thread(helloRunnable);
        thread.start();
        System.out.println(Thread.currentThread().getName()+"end 호출 후");
        System.out.println(Thread.currentThread().getName()+" end");
    }

}
