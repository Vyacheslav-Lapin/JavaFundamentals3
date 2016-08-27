import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.Is.isA;
import static org.junit.Assert.assertThat;

public class Literals {

    boolean statusOn;
    double javaVar = 2.34;

    @Test
    public void intsWorksCorrectly() {

        assertThat(04, isA(int.class));
        assertThat(04, is(4));

        assertThat(0xFd45, isA(int.class));
        assertThat(0xFd45, is(64_837));
    }

    @Test
    public void doublesWorksCorrectly() {
        assertThat(1.234e3, isA(double.class));
        assertThat(1.234e3, is(1_234d));
        assertThat(1.234e3, is(1234.0));
    }

    @Test
    public void floatsWorksCorrectly() {
        assertThat(11.0f, isA(float.class));
        assertThat(11.0f, is(11f));
    }

    @Test
    public void longsWorksCorrectly() {
        assertThat(1_000_000_000_000L, isA(long.class));
    }

    public void method1() {
//        int intVar = 1_000_000_000L; //error
//        intVar = intVar + longVar; //error
        int intVar = 100;
        long longVar = 1_000_000_000_000L;
        intVar += longVar;
        System.out.println(intVar);
    }
}