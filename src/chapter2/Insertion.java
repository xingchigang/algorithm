package chapter2;

/**
 * 将第一个元素标记为已排序
 * for each unsorted element X
 *  extract the element X
 *      for j = lastSortedIndex down to 0
 *          if current element j > X
 *              排序过的元素向右移动一格
 */
public class Insertion {
    public static void sort(Comparable[] a){
        int N = a.length;
        //将第一个元素标记为已排序
        for (int i = 1; i < N; i++){
            for (int j = i; j > 0 && Example.less(a[j], a[j-1]); j--){
                Example.exch(a, j, j-1);
            }
        }
    }
}
