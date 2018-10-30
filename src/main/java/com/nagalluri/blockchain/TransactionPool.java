package com.nagalluri.blockchain;

import java.util.Set;

public class TransactionPool {

    public Set<Transaction> currentTransactions;


    public TransactionPool(Set<Transaction> currentTransactions) {
        this.currentTransactions = currentTransactions;
    }

    public int addTransaction(Transaction transaction) {
        this.currentTransactions.add(transaction);
        return this.currentTransactions.size();
    }

    public Set<Transaction> getAllTransactions() {
        return this.currentTransactions;
    }

    public void clearTransactions() {
        currentTransactions.clear();
    }
}
