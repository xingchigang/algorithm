package chapter1;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex1_2_02 {
    public static void main(String[] args){
        int N = Integer.parseInt(args[0]);
        Interval1D[] interval = new Interval1D[N];
        for (int i = 0; i < N; i++){
            interval[i] = new Interval1D(StdIn.readDouble(), StdIn.readDouble());
        }
        if (N > 2){
            for (int i = 0; i < N; i++){
                for (int j = i+1; j < N; j++){
                    if (interval[i].intersects(interval[j])){
                        StdOut.println(interval[i] + "intersects" + interval[j]);
                    }
                }
            }
        }

    }
}
