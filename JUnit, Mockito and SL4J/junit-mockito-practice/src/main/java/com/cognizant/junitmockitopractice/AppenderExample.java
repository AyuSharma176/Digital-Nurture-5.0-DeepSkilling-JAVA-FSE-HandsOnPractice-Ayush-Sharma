package com.cognizant.junitmockitopractice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppenderExample {

    private static final Logger logger = LoggerFactory.getLogger(AppenderExample.class);

    public static void main(String[] args) {
        // These go to BOTH console and file appenders
        logger.debug("Debug message — goes to console and file");
        logger.info("Info message — goes to console and file");
        logger.warn("Warning message — goes to console and file");
        logger.error("Error message — goes to console and file");

        // Simulating different scenarios
        processUser("Alice", 101);
        processUser("Bob", 202);
    }

    private static void processUser(String name, int id) {
        logger.info("Processing user: {} with ID: {}", name, id);
        try {
            if (id == 202) throw new RuntimeException("User processing failed");
            logger.debug("User {} processed successfully", name);
        } catch (Exception e) {
            logger.error("Failed to process user {}: {}", name, e.getMessage(), e);
        }
    }
}
