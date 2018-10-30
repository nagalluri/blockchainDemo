package com.nagalluri.blockchain;



import org.apache.commons.codec.digest.DigestUtils;

import java.util.List;
import java.util.Set;

public class Block {

    private long index;
    private Set<Transaction> transactions;
    private String previousHash;
    private long proof;

    public Block(long index, Set<Transaction> transactions, String previousHash) {
        this.index = index;
        this.transactions = transactions;
        this.previousHash = previousHash;
        this.proof = createProof();
    }

    public long createProof() {
        this.proof = 0;
        String hash = DigestUtils.sha256Hex(this.toString());
        while (!hash.startsWith("00000")) {
            this.proof += 1;
            hash = DigestUtils.sha256Hex(this.toString());
        }
        return this.proof;
    }

    public long getIndex() {
        return index;
    }

    public void setIndex(long index) {
        this.index = index;
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
