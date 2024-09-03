package com.inflearn.thread.sync;

import static com.inflearn.util.MyLogger.log;
import static com.inflearn.util.ThreadUtils.sleep;

public class BankMain {
    public static void main(String[] args) throws InterruptedException {
        BankAccountV2 account = new BankAccountV2(1000);
        Thread t1 = new Thread(new WithDrawTask(account, 800), "t1");
        Thread t2 = new Thread(new WithDrawTask(account, 800), "t2");
        t1.start();
        t2.start();

        sleep(500);
        log("t1의 상태"+t1.getState());
        log("t2의 상태"+t2.getState());
        t1.join();
        t2.join();
        log("최종잔액:" + account.getBalance());
//        t2.start();
    }
}
