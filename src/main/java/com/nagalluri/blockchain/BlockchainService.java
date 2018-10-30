package com.nagalluri.blockchain;

import org.springframework.stereotype.Component;

import java.util.Set;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

@Component
public class BlockchainService {

    private Blockchain blockchain;

    public BlockchainService() {
    }

    public void init() {
        LOGGER.info("intializing");
        createBlockchain();
    }

    public Blockchain createBlockchain() {
        blockchain = new Blockchain();
        return blockchain.create();
    }

    Blockchain getBlockchain() {
        return blockchain;
    }

    long createTransaction(String id, String to, String from, int amount) {
        Transaction t = new Transaction(id, to, from, amount);
        return 1;
    }

    String getPendingTransactions() {
        return "null";
    }

    Block mine() {
        return null;
    }

    Set<String> getPeers() {
        return null;
    }

    boolean isValid() {
        return true;
    }

}
