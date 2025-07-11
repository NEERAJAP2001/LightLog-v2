package com.example.logproducer;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.logging.Logger;

@Service
public class LoggingService {

    private static final Logger logger = Logger.getLogger(LoggingService.class.getName());

    @Scheduled(fixedRate = 5000)
    public void produceLogs() {
        logger.info("Info: Application running smoothly.");
        logger.warning("Warning: Check application performance.");
        logger.severe("Error: Simulated error for Kafka log testing.");
    }
}