package com.epam.courses.jf.intro.homework.t05;

public class CrossMatrix {

    private int size;

    @SuppressWarnings("WeakerAccess")
    public CrossMatrix(int size) {
        this.size = size;
    }

    @SuppressWarnings("WeakerAccess")
    public boolean get(int x, int y) {
        assert x < size && y < size;
        return x == y || (x == size - y - 1);
    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++)
                result.append(get(x, y) ? "1 " : "0 ");
            result.append("\n");
        }
        return result.toString();
    }
}
