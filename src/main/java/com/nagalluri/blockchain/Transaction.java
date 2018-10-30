package com.nagalluri.blockchain;

public class Transaction {

    private String id;
    private String from;
    private String to;
    private int amount;

    public Transaction(String id, String from, String to, int amount) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
