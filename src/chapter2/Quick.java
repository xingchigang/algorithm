package chapter2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;
import org.apache.batik.apps.svgpp.Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Quick {
    public static int partition(Comparable[] a, int lo, int hi){
        //左扫描指针：
        int i = lo;
        //右扫描指针：
        int j = hi+1;
        //切分元素
        Comparable v = a[lo];
        //当指针i和j相遇时主循环退出
        while (true){
            //less()方法，如果是int相当于a[++i] - v；如果a[++i] 小于 v 则返回一个负整数，while不会循环
            while (Example.less(a[++i], v)){
                if (i == hi){
                    break;
                }
            }
            while (Example.less(v, a[--j])){
                if (j == lo){
                    break;
                }
            }
            if (i >= j){
                break;
            }
            Example.exch(a, i, j);
        }
        Example.exch(a, lo, j);
        return j;
    }
    public static void sort(Comparable[] a){
        StdRandom.shuffle(a);
        sort(a, 0, a.length-1);
    }
    private static void sort(Comparable[] a, int lo, int hi){
        if (hi <= lo){
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }
    public static void main(String[] args) throws IOException {
        FileInputStream test_file = new FileInputStream(new File("E:\\IdeaProject\\algorithm\\data\\algorithm_test_data.txt"));
        System.setIn(test_file);
        Main.main(args);
        String[] a = StdIn.readAllStrings();
        sort(a);
        assert Example.isSorted(a);
        Example.show(a);
    }
}
