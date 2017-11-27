package chapter1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StaticSETofInts;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class WhiteList {
    private  WhiteList(){}
    public static void main(String[] args){
        In in = new In(args[0]);
        int[] white = in.readAllInts();
        StaticSETofInts set = new StaticSETofInts(white);
        while (!StdIn.isEmpty()){ //读取键，如果不在白名单中则打印它
            int key = StdIn.readInt();
            if (!set.contains(key)){
                StdOut.println(key);
            }
        }
    }
}
