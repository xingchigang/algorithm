package practice;

public class Insertion {
    public static void sort(Comparable[] a){
        int N = a.length;
        for (int i = 1; i < N; i++){
            for (int j = i; j > 0 && SortTest.less(a[j], a[j-1]); j--){
                SortTest.exch(a, j, j-1);
            }
        }
    }
}
