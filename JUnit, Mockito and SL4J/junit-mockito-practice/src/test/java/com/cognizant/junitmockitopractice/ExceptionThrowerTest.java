package com.cognizant.junitmockitopractice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionThrowerTest {

    ExceptionThrower thrower = new ExceptionThrower();

    @Test
    public void testThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            thrower.throwException(true);
        });
    }

    @Test
    public void testNoExceptionWhenFalse() {
        assertDoesNotThrow(() -> thrower.throwException(false));
    }

    @Test
    public void testDivideByZero() {
        ArithmeticException ex = assertThrows(ArithmeticException.class,
                () -> thrower.divide(10, 0));
        assertEquals("Division by zero", ex.getMessage());
    }
}
