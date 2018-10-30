package com.nagalluri.blockchain;

import org.omg.CORBA.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

@Component
public class BlockchainService {

    private Blockchain blockchain;
    private TransactionPool transactionPool;
    private String miningWalletId;

    public BlockchainService() {
    }

    public void init(int port) {
        LOGGER.info("Initializing New Blockchain");
        miningWalletId = String.valueOf(port);
        createBlockchain();
    }

    public Blockchain createBlockchain() {
        this.blockchain = new Blockchain();

        transactionPool = new TransactionPool(new HashSet<Transaction>());
        return blockchain.create();
    }

    Blockchain getBlockchain() {
        return blockchain;
    }

    long createTransaction(String from, String to, int amount) {
        Transaction t = new Transaction(from, to, amount);
        return transactionPool.addTransaction(t);
    }

    Set<Transaction> getPendingTransactions() {
        return transactionPool.getAllTransactions();
    }

    Block mine() {
        Set<Transaction> transactions = transactionPool.getAllTransactions();
        Block minedBlock = blockchain.mineNewBlock(transactions, miningWalletId);
        transactionPool.clearTransactions();
        return minedBlock;
    }

    Set<String> getPeers() {
        return null;
    }

    boolean isValid() {
        return true;
    }

}
