package chapter2;

import edu.princeton.cs.algs4.StdDraw;

public class Show {
    public static void show(double[] a, int i, int min) {
        StdDraw.setYscale(-a.length + i + 1, i);
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        for (int k = 0; k < i; k++) {
            StdDraw.line(k, 0, k, a[k] * 0.6);
        }
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int k = i; k < a.length; k++) {
            StdDraw.line(k, 0, k, a[k] * 0.6);
        }
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        StdDraw.line(min, 0, min, a[min]*0.6);
    }
}
