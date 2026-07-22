package com.cognizant.junitmockitopractice;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTests {

    @Test
    @Order(1)
    public void firstTest() {
        System.out.println("First test runs");
        assertTrue(true);
    }

    @Test
    @Order(2)
    public void secondTest() {
        System.out.println("Second test runs");
        assertEquals(4, 2 + 2);
    }

    @Test
    @Order(3)
    public void thirdTest() {
        System.out.println("Third test runs");
        assertNotNull("Hello");
    }
}
