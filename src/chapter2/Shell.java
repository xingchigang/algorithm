package chapter2;

public class Shell {
    public static void sort(Comparable[] a){
        int N = a.length;
        int h = 1;
        //找到比N小的最大h：
        while (h < N/3){
            h = 3*h + 1;
        }
        while (h >= 1){
            //将数组变为h有序：
            for (int i = h; i < N; i++){
                //将a[i]插入到a[i-h],a[i-2*h],a[i-3*h]....中:
                for (int j = i; j >= h && Example.less(a[j], a[j-h]); j -= h){
                    Example.exch(a, j, j-h);
                }
            }
            h = h/3;
        }
    }
}
