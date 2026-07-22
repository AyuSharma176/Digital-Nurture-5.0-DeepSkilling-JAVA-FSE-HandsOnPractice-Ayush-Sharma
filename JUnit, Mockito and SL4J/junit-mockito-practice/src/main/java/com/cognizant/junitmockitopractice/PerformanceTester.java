package com.cognizant.junitmockitopractice;

public class PerformanceTester {
    public void performTask() throws InterruptedException {
        // Simulates a fast task
        Thread.sleep(100);
        System.out.println("Task completed");
    }

    public void slowTask() throws InterruptedException {
        // Simulates a slow task
        Thread.sleep(3000);
    }
}
