package com.inflearn.thread.sync;

import static com.inflearn.util.MyLogger.log;
import static com.inflearn.util.ThreadUtils.sleep;

public class BankAccountV2 implements BankAccount {
    private int balance;

    public BankAccountV2(int initBalance) {
        this.balance = initBalance;
    }
    
    @Override
    public synchronized boolean withdraw(int amount) {
        log("거래 시작: " + getClass().getSimpleName());
        // 잔고가 출금액보다 적으면 진행하면 안됨.
        log("[검증 시작] 출금약: " + amount + "잔액" + balance);
        if (balance < amount) {
            log("[검증 실패] 출금액: " + amount + "잔액" + balance);
            return false;
        }
        // 잔고가 출금액보다 많으면 진행
        log("[검증 완료] 출금액: " + amount + "잔액" + balance);

        sleep(1000);
//        balance =balance- amount;
        balance -= amount;
        log("[출금] 출금액: " + amount + "잔액" + balance);

        log("거래 종료");
        return true;
    }

    @Override
    public synchronized int getBalance() {
        return balance;
    }
}
