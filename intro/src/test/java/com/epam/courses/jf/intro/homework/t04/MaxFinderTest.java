package com.epam.courses.jf.intro.homework.t04;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxFinderTest {

    @Test
    public void testGetMaximum() throws Exception {
        assertEquals(62,
                new MaxFinder(new double[] {1, 2, 63, -1, 0, 40})
                        .getMaximum(), 0.1);
    }
}
