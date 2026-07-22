package com.cognizant.junitmockitopractice;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

// pom.xml needs: junit-platform-suite dependency
@Suite
@SelectClasses({
        CalculatorTest.class,
        AssertionsTest.class,
        EvenCheckerTest.class
})
public class AllTests {
    // Empty — just groups the test classes
}
