package com.epam.training.jf.se1.mypackage;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CountryTest {

    private Country country = () -> "Russia";

    @Test
    public void getCode() throws Exception {
        assertThat(country.getCode(), is("RU"));
    }

}