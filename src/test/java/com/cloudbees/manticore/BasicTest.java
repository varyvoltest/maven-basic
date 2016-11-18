package com.cloudbees.manticore;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Simple unit test.
 */
public class BasicTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName
     *            name of the test case
     */
    public BasicTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(BasicTest.class);
    }

    /**
     * Test failing depending on the existence of mavenBasicNotFail property
     */
    public void testPropertyExistence() throws InterruptedException {
        assertNotNull(System.getProperty("mavenBasicNotFail"));
    }
}
