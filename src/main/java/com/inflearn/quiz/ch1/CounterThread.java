package com.inflearn.quiz.ch1;

import com.inflearn.util.MyLogger;

public class CounterThread extends Thread{
    @Override
    public void run(){
        for(int i = 1; i < 6; i++){
            MyLogger.log("value :"+i);
            try{
                Thread.sleep(1000);// 1초간 대기
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }


}
