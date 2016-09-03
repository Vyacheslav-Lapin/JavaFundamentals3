package com.epam.courses.jf.intro;

public class Modifiers {
    public static void main(String[] args) {
        AboutJava obj = new AboutJava();
        String s1 = obj.getAboutJava();
//        String s2 = obj.info(); // error
    }
}
class AboutJava{
    public String getAboutJava(){
        return info();
    }

    private String info(){
        return "About Java.";
    }
}