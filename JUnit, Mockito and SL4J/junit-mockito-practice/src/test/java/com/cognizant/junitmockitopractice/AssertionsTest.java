package com.cognizant.junitmockitopractice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {

    @Test
    public void testAssertions() {
        // Assert equals
        assertEquals(5, 2 + 3);

        // Assert true
        assertTrue(5 > 3);

        // Assert false
        assertFalse(5 < 3);

        // Assert null
        assertNull(null);

        // Assert not null
        assertNotNull(new Object());

        // Assert array equals
        assertArrayEquals(new int[]{1, 2, 3}, new int[]{1, 2, 3});

        // Assert throws
        assertThrows(ArithmeticException.class, () -> {
            int result = 10 / 0;
        });
    }
}
