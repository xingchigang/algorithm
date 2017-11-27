package practice;

public class Selection {
    public static void sort(Comparable[] a){
        int N = a.length;
        for (int i = 0; i < N; i++){
            int min = i;
            for (int j = i+1; j < N; j++){
                if (SortTest.less(a[j], a[min])){
                    min = j;
                }
            }
            SortTest.exch(a, i, min);
        }
    }
}
