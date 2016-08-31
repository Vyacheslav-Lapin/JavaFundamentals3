package com.epam.training.jf.se1.mypackage;

@FunctionalInterface
public interface Country {

    String getName();

    default String getCode() {
        String name = getName();
        return name.substring(0, 2).toUpperCase();
    }
}
