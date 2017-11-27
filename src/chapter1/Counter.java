package chapter1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Counter implements Comparable<Counter> {
    //implements声明自己使用一个或者多个接口。
    // Comparable defines a natural ordering.
    // What this means is that you're defining it when one
    // object should be considered "less than" or "greater than"
    private final String name; //实例变量
    private int count = 0;     //实例变量

    public Counter(String id){  //id为counter的名字
        name = id;
    }

    public void increment(){
        count++;
    }

    public String toString(){
        return count + "" + name;
    }

    public int compareTo(Counter that){
        if (this.count < that.count) return -1; //this关键字：指向自己的引用
        else if (this.count > that.count) return +1;
        else return 0;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        // create n counters
        Counter[] hits = new Counter[n];
        for (int i = 0; i < n; i++) {
            hits[i] = new Counter("counter" + i);
        }

        // increment trials counters at random
        for (int t = 0; t < trials; t++) {
            hits[StdRandom.uniform(n)].increment();
        }

        // print results
        for (int i = 0; i < n; i++) {
            StdOut.println(hits[i]);
        }
    }
}
