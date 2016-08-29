package com.epam.training.jf.se1.mypackage;

import java.util.ArrayList;
import java.util.List;

@MyAnno(value = false)
public class GenericExperiment {

    private String x;

    public GenericExperiment(String x) {
        this.x = x;
    }

    public static void main(String[] args) {
//        List<? super com.epam.training.jf.se1.mypackage.Doctor> list7 = new ArrayList<com.epam.training.jf.se1.mypackage.HeadDoctor>(); // error
        List<? super Doctor> list6 = new ArrayList<>();
        List<? super Doctor> list5 = new ArrayList<MedicalStaff>();
        List<? super Doctor> list4 = new ArrayList<Object>();

//        list5.add(new Object()); // error
//        list5.add(new com.epam.training.jf.se1.mypackage.MedicalStaff()); // error
        list5.add(new Doctor());
        list5.add(new HeadDoctor());

        Object object = list5.get(0);
//        com.epam.training.jf.se1.mypackage.MedicalStaff medicalDtaff = list5.get(0); //error
//        com.epam.training.jf.se1.mypackage.Doctor doctor = list5.get(0); //error
//        com.epam.training.jf.se1.mypackage.HeadDoctor headDoctor = list5.get(0); //error

        MyAnno myAnno = (MyAnno) GenericExperiment.class.getAnnotations()[0];
        System.out.println(myAnno.value());
    }
}

class MedicalStaff {}
class Doctor extends MedicalStaff {}
class HeadDoctor extends Doctor {}
class Nurse extends MedicalStaff {}