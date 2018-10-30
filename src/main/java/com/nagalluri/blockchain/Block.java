package com.nagalluri.blockchain;

import java.util.List;

public class Block {

    private long index;
    private List<Transaction> transactions;
    private String previousHash;
    private long proof;

    public Block(long index, List<Transaction> transactions, String previousHash, long proof) {
        this.index = index;
        this.transactions = transactions;
        this.previousHash = previousHash;
        this.proof = proof;
    }

    public long getIndex() {
        return index;
    }

    public void setIndex(long index) {
        this.index = index;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public long getProof() {
        return proof;
    }

    public void setProof(long proof) {
        this.proof = proof;
    }

    @Override
    public String toString() {
        return "Block{" +
                "index=" + index +
                ", transactions=" + transactions +
                ", previousHash='" + previousHash + '\'' +
                ", proof=" + proof +
                '}';
    }
}
