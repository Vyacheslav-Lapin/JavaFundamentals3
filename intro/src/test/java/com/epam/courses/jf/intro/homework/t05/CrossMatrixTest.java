package com.epam.courses.jf.intro.homework.t05;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * @author Vyacheslav_Lapin
 */
public class CrossMatrixTest {

    @Test
    public void testGet() throws Exception {

        CrossMatrix crossMatrix = new CrossMatrix(6);

        assertTrue(crossMatrix.get(1, 1));
        assertTrue(crossMatrix.get(5, 5));
        assertTrue(crossMatrix.get(0, 5));
        assertFalse(crossMatrix.get(4, 5));

        assertThat(crossMatrix.toString(), is(
                "1 0 0 0 0 1 \n" +
                "0 1 0 0 1 0 \n" +
                "0 0 1 1 0 0 \n" +
                "0 0 1 1 0 0 \n" +
                "0 1 0 0 1 0 \n" +
                "1 0 0 0 0 1 \n"));
    }
}