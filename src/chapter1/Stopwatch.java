package chapter1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Stopwatch {
    private final long start;

    /**
     * Stopwatch的构造函数，创建Stopwatch对象时，开始进行计数，计数起始位置为当前的系统时间
     */
    public Stopwatch(){
        start = System.currentTimeMillis();
    }

    /**
     * elapsedTime()方法返回自它创建以来所经过的时间
     * 其中curreTimeMillis()方法返回已毫秒计数的当前时间
     * @return
     */
    public double elapsedTime(){
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }


    public static void main(String[] args){
        int N = Integer.parseInt(args[0]);
        int[] a = new int[N];
        for (int i = 0; i < N; i++){
            a[i] = StdRandom.uniform(-1000000, 1000000);
        }
        Stopwatch timer = new Stopwatch();
        int cnt = ThreeSum.count(a);
        double time = timer.elapsedTime();
        StdOut.println(cnt + "triples" + time + "seconds");
    }
}
