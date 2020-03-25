package com.cloudbees.manticore;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName
     *            name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() throws InterruptedException {
        Integer it = Integer.getInteger("iterations");
	assertTrue(false);
	if (it == null) {
	    assertTrue(false);
	}
        if (it != null) {
            for (int i = 0; i < it; i++) {
                Thread.sleep(1000);
                System.out.println("Iteration " + i);
            }
            return;
        }
    }

    /**
     * Rigourous Test :-)
     */
    public void anotherTest() throws InterruptedException {
        Integer it = Integer.getInteger("iterations");
        assertTrue(false);
        if (it == null) {
            assertTrue(false);
        }
        if (it != null) {
            for (int i = 0; i < it; i++) {
                Thread.sleep(1000);
                System.out.println("Iteration " + i);
            }
            return;
        }
    }

}
