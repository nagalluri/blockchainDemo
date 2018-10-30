package com.nagalluri.blockchain;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api")
public class BlockchainApplicationController {

    private final BlockchainService blockchainService;

    public BlockchainApplicationController(BlockchainService blockchainService) {
        this.blockchainService = blockchainService;
    }

    /**
     * Find and return the blockchain of this node
     * @return the blockchain that this node belongs to
     */
    @GetMapping("/blockchain")
    public Blockchain getBlockchain() {
        return blockchainService.getBlockchain();
    }

    /**
     * Create a new transaction on this node
     * @return a string describing which block the transaction
     * will be added to
     */
    @PostMapping("/newtransaction")
    public String createTransaction(String id, String to, String from, int amount) {
        long l = blockchainService.createTransaction(id, to, from, amount);
        return "{\"message\": \"new transaction will be added to block " + l + "\"}";
    }

    /**
     * Find and return all of the transactions in the transaction pool.
     * @return All transactions in the transaction pool
     */
    @GetMapping("/gettransactions")
    public String getPendingTransactions() {
        return blockchainService.getPendingTransactions();
    }

    /**
     * Starts the process of mining a new block
     * @return the mined block
     */
    @PostMapping("/mine")
    public Block mine() {
        return blockchainService.mine();
    }

    /**
     * Return the list of known peers
     * @return the list of known peers
     */
    @GetMapping("/peers")
    public Set<String> getPeers() {
        return blockchainService.getPeers();
    }

    /**
     * Checks the validity of the blockchain of this node
     * @return a boolean representing whether or not the blockchain
     * is valid.
     */
    @GetMapping("/valid")
    public boolean isValid() {
        return blockchainService.isValid();
    }


}
