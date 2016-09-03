package com.epam.courses.jf.intro.homework.t02;

import org.junit.Test;

import static com.epam.courses.jf.intro.homework.t02.MinFinder.findMin;
import static common.test.Tests.fromSystemOutPrintln;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MinFinderTest {

    @Test
    public void testFindMin() {
        int[] min = new int[1];
        String output = fromSystemOutPrintln(() -> min[0] = findMin(0.1));
        assertThat(output, is("0.25\n0.1111111111111111"));
        assertThat(min[0], is(3));
    }
}
