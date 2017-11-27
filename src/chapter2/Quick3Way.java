package chapter2;

/**
 * 指针lt的作用是使得a[lo,lt-1]中的元素都小于v
 * 指针gt的作用是使得a[gt+1,hi]中的元素都大于v
 * 指针t的作用是使得a[lt,i-1]中的元素都等于v
 * a[i,gt]中的元素还未确定
 */
public class Quick3Way {
    private static void sort(Comparable[] a, int lo, int hi){
        if (hi <= lo){
            return;
        }
        int lt = lo, i = lo+1, gt = hi;
        Comparable v = a[lo];
        while (i <= gt){
            int cmp = a[i].compareTo(v);
            //a[i]小于v
            if (cmp < 0){
                //将a[lt],a[i]交换,将lt和i加1
                Example.exch(a, lt++, i++);
            }
            //a[i]大于v
            else if (cmp > 0){
                //将a[i],a[gt]交换，将gt减1
                Example.exch(a, i, gt--);
            }
            //a[i]等于v
            else {
                i++;
            }
        }
        sort(a, lo, lt-1);
        sort(a, gt+1, hi);
    }
    public static void sort(Comparable[] a){
        sort(a, 0, a.length-1);
    }
}
