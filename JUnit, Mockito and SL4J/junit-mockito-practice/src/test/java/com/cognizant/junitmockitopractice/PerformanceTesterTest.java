package com.cognizant.junitmockitopractice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

public class PerformanceTesterTest {

    PerformanceTester tester = new PerformanceTester();

    @Test
    @Timeout(value = 1, unit = TimeUnit.SECONDS)
    public void testPerformTaskCompletesInTime() throws InterruptedException {
        tester.performTask(); // must finish within 1 second
    }

    @Test
    public void testSlowTaskExceedsTimeout() {
        assertThrows(Exception.class, () -> {
            assertTimeoutPreemptively(
                    java.time.Duration.ofSeconds(1),
                    () -> tester.slowTask()
            );
        });
    }
}
