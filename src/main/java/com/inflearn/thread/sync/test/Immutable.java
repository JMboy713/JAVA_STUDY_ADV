package com.inflearn.thread.sync.test;

public class Immutable {
    private final int value; // 공유되는 값
    // final 이 붙으면 변경할 수 없다. 멀티스레드 상황에 문제없는 안전한 공유자원이 된다.

    public Immutable(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
