package com.cognizant.junitmockitopractice;

public class ExceptionThrower {
    public void throwException(boolean shouldThrow) {
        if (shouldThrow) {
            throw new IllegalArgumentException("Exception thrown!");
        }
    }

    public int divide(int a, int b) {
        if (b == 0) throw new ArithmeticException("Division by zero");
        return a / b;
    }
}
