package com.thoughtworks.tddintro.accountbalance;

/**
 * Created by Kathryn on 6/2/2016.
 * Implements an account balance
 */
public class Account {

    private int balance;

    public Account(){
        balance = 0;
    }

    public Account(int initialBalance){
        balance = initialBalance;
    }

    public void deposit(int depositAmount) {
        balance += depositAmount;
    }

    public int balance() {
        return balance;
    }

    public void withdraw(int withdrawAmount) {
        if(balance >= withdrawAmount)
            balance -= withdrawAmount;
    }
}
