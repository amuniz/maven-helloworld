package com.cloudbees.manticore;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * Rigourous Test :-)
     */
    @Test
    public void testApp() throws InterruptedException {
        Integer it = Integer.getInteger("iterations");
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
    @Test
    public void anotherTest() throws InterruptedException {
        Integer it = Integer.getInteger("iterations");
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
