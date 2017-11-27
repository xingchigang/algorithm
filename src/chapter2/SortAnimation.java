package chapter2;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import org.apache.batik.apps.svgpp.Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 动态演示效果，
 * 其中：StdDraw.setCanvasSize(Width, Hight)用以确定绘制图像的窗口大小
 */
public class SortAnimation {
    public static void drawSort(Comparable[] a) {
        int N = a.length;
        StdDraw.setCanvasSize(2560,1440);
        StdDraw.setYscale(N + 1, 0);
        StdDraw.setXscale(0, N + 1);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(3 + N / 2, 0.4, "a[ ]");
        StdDraw.textRight(1, 1, "i");
        StdDraw.textRight(2, 1, "min");
        for (int i = 0; i < N; i++) {
            StdDraw.text(3 + i, 1, i + " ");
            StdDraw.text(3 + i, 2, a[i].toString());
        }
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (Example.less(a[j], a[min])) {
                    min = j;
                }
            }
            StdDraw.textRight(1, 3 + i, i + " ");
            StdDraw.textRight(2, 3 + i, min + " ");
            StdDraw.setPenColor(StdDraw.GRAY);
            for (int j = 0; j < N; j++) {
                if (j == i) {
                    StdDraw.setPenColor(StdDraw.BLACK);
                }
                if (j == min) {
                    StdDraw.setPenColor(StdDraw.RED);
                }
                StdDraw.text(3 + j, 3 + i, a[j].toString());
                if (j == min) {
                    StdDraw.setPenColor(StdDraw.BLACK);
                }
            }
            Example.exch(a, i, min);
        }
        for (int i = 0; i < N; i++) {
            StdDraw.text(3 + i, N + 3, a[i].toString());
        }
    }
    public static void main(String[] args) throws IOException {
        FileInputStream test_file = new FileInputStream(new File("E:\\IdeaProject\\algorithm\\data\\algorithm_test_data.txt"));
        System.setIn(test_file);
        Main.main(args);
        String[] a = StdIn.readAllStrings();
        Merge.sort(a);
        assert Example.isSorted(a);
        drawSort(a);
    }
}
