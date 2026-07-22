package com.cognizant.junitmockitopractice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLogging {

    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLogging.class);

    public static void main(String[] args) {
        String username = "John";
        int userId = 42;
        double balance = 1500.75;

        // Parameterized logging — {} is the placeholder
        logger.info("User {} logged in with ID {}", username, userId);
        logger.debug("Account balance for user {}: {}", username, balance);
        logger.warn("User {} has low balance: {}", username, balance);

        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            logger.error("Error occurred for user {}: {}", username, e.getMessage(), e);
        }
    }
}
