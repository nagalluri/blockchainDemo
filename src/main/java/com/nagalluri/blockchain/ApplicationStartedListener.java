package com.nagalluri.blockchain;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartedListener implements ApplicationListener<ApplicationStartedEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationListener.class);

    private final Environment environment;
    private final BlockchainService blockchainService;

    @Autowired
    public ApplicationStartedListener(Environment environment, BlockchainService blockchainService) {
        this.environment = environment;
        this.blockchainService = blockchainService;
    }

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        LOGGER.info("=============Application Started==============");
        Integer port = environment.getProperty("local.server.port", Integer.class);
        LOGGER.info("Running on port " + port);
        blockchainService.init(port);
    }
}
