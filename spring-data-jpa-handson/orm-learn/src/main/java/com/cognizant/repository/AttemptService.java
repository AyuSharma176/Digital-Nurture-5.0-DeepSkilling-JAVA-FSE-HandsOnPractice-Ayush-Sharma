package com.cognizant.service;

import com.cognizant.model.Attempt;
import com.cognizant.repository.AttemptRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AttemptService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AttemptService.class);

    @Autowired
    private AttemptRepository attemptRepository;

    @Transactional
    public Attempt getAttempt(int userId, int attemptId) {
        LOGGER.info("start");
        return attemptRepository.getAttempt(userId, attemptId);
    }
}