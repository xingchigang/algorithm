package chapter2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import org.apache.batik.apps.svgpp.Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Example {
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    public static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    public static void show(Comparable[] a){
        for (int i = 0; i < a.length; i++){
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }
    public static boolean isSorted(Comparable[] a){
        for (int i = 1; i < a.length; i++){
            if(less(a[i], a[i-1])) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        FileInputStream test_file = new FileInputStream(new File("E:\\IdeaProject\\algorithm\\data\\algorithm_test_data.txt"));
        System.setIn(test_file);
        Main.main(args);
        String[] a = StdIn.readAllStrings();
        Merge.sort(a);
        assert isSorted(a);
        show(a);
    }
}