package com.nagalluri.blockchain;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Blockchain {

    private LinkedList<Block> blocks;
    private Block lastBlock;
    private int height;

    public Blockchain() {
        this.blocks = new LinkedList<Block>();
        this.lastBlock = null;
        this.height = 0;
    }

    public LinkedList<Block> getBlocks() {
        return blocks;
    }

    public void addBlock(Block block) {
        this.blocks.add(block);
        this.lastBlock = block;
        this.height += 1;
    }

    public Blockchain create() {
        Block genesisBlock = new Block(0, new HashSet<Transaction>(), "0");
        this.addBlock(genesisBlock);
        return this;
    }

    public Block mineNewBlock(Set<Transaction> includedTransactions, String miningWalletId) {
        Transaction reward = new Transaction("", miningWalletId, 10);
        includedTransactions.add(reward);
        Block block = new Block(height, includedTransactions, DigestUtils.sha256Hex(lastBlock.toString()));
        addBlock(block);
        return block;
    }
}
