package com.cognizant.junitmockitopractice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class EvenCheckerTest {

    EvenChecker checker = new EvenChecker();

    // Test even numbers
    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 100})
    public void testIsEven(int number) {
        assertTrue(checker.isEven(number));
    }

    // Test odd numbers
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 99})
    public void testIsOdd(int number) {
        assertFalse(checker.isEven(number));
    }

    // Test with CSV (input + expected)
    @ParameterizedTest
    @CsvSource({"2, true", "3, false", "4, true", "7, false"})
    public void testIsEvenWithExpected(int number, boolean expected) {
        assertEquals(expected, checker.isEven(number));
    }
}
