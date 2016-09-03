package com.epam.courses.jf.intro.homework.t01.main;

import org.junit.Test;

import static common.test.Tests.fromSystemOutPrintln;
import static junit.framework.Assert.assertEquals;

public class MainTest {

    @Test
    public void main() throws Exception {
        assertEquals("I am string in Logic.", fromSystemOutPrintln(Main::main));
    }
}
