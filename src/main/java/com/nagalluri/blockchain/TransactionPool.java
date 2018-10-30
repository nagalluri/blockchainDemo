package com.nagalluri.blockchain;

import java.util.Set;

public class TransactionPool {

    private Set<Transaction> transactions;

    public TransactionPool(Set<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void clearTransaction() {
        transactions.clear();
    }
}
