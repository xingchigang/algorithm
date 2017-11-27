package chapter1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import org.apache.batik.apps.svgpp.Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FixedCapacityStackStrings {
    private String[] a;
    private int N;

    public FixedCapacityStackStrings(int cap) {
        a = new String[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(String item) {
        a[N++] = item;
    }

    public String pop() {
        return a[--N];
    }

    /**
     * 练习1.3.1
     * @return
     */
    public boolean isFull(){
        return N == a.length;
    }


    public static void main(String[] args) throws IOException{
        FixedCapacityStackStrings s = new FixedCapacityStackStrings(100);
        FileInputStream is = new FileInputStream((new File("E:\\IdeaProject\\algorithm\\data\\test.txt")));
        System.setIn(is);
        Main.main(args);
            while (!StdIn.isEmpty()) {
                String item = StdIn.readString();
                if (!item.equals("-")) {
                    s.push(item);
                } else if (!s.isEmpty()) {
                    StdOut.print(s.pop() + " ");
                }
            }
        StdOut.println("(" + s.size() + " " + "left on stack)");
        if (s.isFull()){
            StdOut.println("Stack is full");
        }
        else {
            StdOut.println("Stack is not full");
        }
    }
}
