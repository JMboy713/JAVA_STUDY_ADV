package com.inflearn.quiz.ch1;

public class StartTest1Main {
    public static void main(String[] args) {
        CounterThread counterThread = new CounterThread();
        counterThread.start();
    }
}
