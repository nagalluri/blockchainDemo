package com.nagalluri.blockchain;

import java.util.ArrayList;
import java.util.LinkedList;

public class Blockchain {

    private LinkedList<Block> blocks;

    public Blockchain() {
        this.blocks = new LinkedList<Block>();
    }

    public LinkedList<Block> getBlocks() {
        return blocks;
    }

    public void addBlock(Block block) {
        this.blocks.add(block);
    }

    public Blockchain create() {
        Block genesisBlock = new Block(0, new ArrayList<Transaction>(), "0",100);
        this.addBlock(genesisBlock);
        return this;
    }
}
