package chapter1;

import edu.princeton.cs.algs4.StdOut;

public class Matrix {
    public static double dot(double[] x, double[] y){                       //向量的点乘。
        int result = 0;
        if (x.length == y.length){
            for (int i = 0; i < x.length; i++){                             //注意数组的越界问题，所以是<，而不是<=
                result += x[i] * y[i];
            }
            return result;
        }
        else {
            StdOut.println("ERROR!");
            return 0;
        }
    }
    public static double[][] mult(double[][] a, double[][] b){              //向量的叉乘
        if (a[0].length == b.length){                                       //a的列数=b的行数
            double result[][] = new double[a.length][b[0].length];
            for (int i = 0; i < result.length; i++){
                for (int j = 0; j < result[i].length; j++){                //遍历乘积结果中的所有行
                    for (int k = 0; k < a[0].length; k++) {                   //遍历乘积结果中的所有列
                        result[i][j] += a[i][k] * b[k][j];                  //第ij个元素的结果a中的第i行第k列与b中的第k行第j列相乘
                    }
                }
            }
            return result;
        }
        else {
            StdOut.println("ERROR!");
            return null;
        }
    }
    public static double[][] traspose(double[][] a){                       //矩阵转置
        double[][] t = new double[a[0].length][a.length];
        for (int i = 0; i < t.length; i++){
            for (int j = 0; j < t[i].length; j++){
                t[i][j] = a[j][i];
            }
        }
        return t;
    }
    public static double[] mult(double[][] a, double[] x){                 //矩阵和向量相乘
        if (a[0].length == x.length){
            double[] s = new double[a.length];
            for (int i = 0; i < s.length; i++) {
                for (int j = 0; j < x.length; j++) {
                    s[i] += a[i][j] * x[j];
                }
            }
            return s;
        }
        else {
            StdOut.println("ERROR!");
            return null;
        }
    }
    public static double[] mult(double[] y, double[][] a){                   //向量和矩阵相乘
        if (y.length == a.length){
            double[] s = new double[y.length];
            for (int i = 0; i < s.length; i++){
                for (int j = 0; j < y.length; j++){
                    s[i] += y[j] * a[j][i];
                }
            }
            return s;
        }
        else{
            StdOut.println("ERROR!");
            return null;
        }
    }
    public static void printM(double[][] matrix) {
        if (matrix != null) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    System.out.printf("%-8.1f", matrix[i][j]);  //保留1位小数;
                }
                System.out.println();
            }
        } else {
            System.out.println("无效");
        }
        System.out.println();
    }
}
