import com.epam.training.jf.se1.mypackage.GenericExperiment;
import com.epam.training.jf.se1.mypackage.MyAnno;

import java.lang.reflect.Field;

public class MyClass {
    public static void main(String[] args) throws NoSuchFieldException,
            IllegalAccessException {

        GenericExperiment genericExperiment = new GenericExperiment("Мама мыла раму");

        Field field = genericExperiment.getClass()
                .getDeclaredField("x");

        field.setAccessible(true);

        System.out.println(field.get(genericExperiment));

        System.out.println(genericExperiment.getClass()
                .getAnnotation(MyAnno.class)
                .value());

    }
}