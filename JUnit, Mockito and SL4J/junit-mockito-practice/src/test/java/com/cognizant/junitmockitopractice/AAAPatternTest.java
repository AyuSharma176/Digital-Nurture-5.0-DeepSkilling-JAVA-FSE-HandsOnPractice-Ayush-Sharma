package com.cognizant.junitmockitopractice;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class AAAPatternTest {

    private Calculator calculator;

    @BeforeEach  // runs before each test (replaces JUnit4 @Before)
    public void setUp() {
        System.out.println("Setting up...");
        calculator = new Calculator();
    }

    @AfterEach  // runs after each test (replaces JUnit4 @After)
    public void tearDown() {
        System.out.println("Tearing down...");
        calculator = null;
    }

    @BeforeAll  // runs once before all tests
    static void initAll() {
        System.out.println("Before all tests");
    }

    @AfterAll  // runs once after all tests
    static void tearDownAll() {
        System.out.println("After all tests");
    }

    @Test
    public void testAdd() {
        // Arrange
        int a = 5;
        int b = 3;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(8, result);
    }

    @Test
    public void testDivide() {
        // Arrange
        int a = 10;
        int b = 2;

        // Act
        double result = calculator.divide(a, b);

        // Assert
        assertEquals(5.0, result);
    }
}