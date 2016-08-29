package com.epam.training.jf.se1.mypackage;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Person {
    private Date dob;
    private String fio;
    private boolean isFemale;
}
