package com.epam.courses.jf.intro.homework.t04;

/**
 * MaxFinder.
 *
 * @author Vyacheslav_Lapin
 */
@SuppressWarnings("WeakerAccess")
public class MaxFinder {

    private double[] as;

    public MaxFinder(double... as) {
        assert as.length % 2 == 0;
        this.as = as;
    }

    public double getMaximum() {
        final int n2 = as.length - 1; // "2n" is an incorrect identifier, so - "n2"...
        final int n = as.length / 2;

        double max = Double.NEGATIVE_INFINITY;
        for (int i = 0; i <= n; i++) {
            double a = as[i] + as[n2 - i];
            if (a > max)
                max = a;
        }
        return max;
    }
}
