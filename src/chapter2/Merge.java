package chapter2;

/**
 * 自顶向下的归并排序：
 */
public class Merge {
    /**
     * 归并所需的辅助数组
     */
    private static Comparable[] aux;

    /**
     * 原地归并方法：
     * @param a 数组a
     * @param lo 数组最左侧（起始）元素
     * @param mid 数组中间元素
     * @param hi 数组最右侧（末尾）元素
     */
    public static void merge(Comparable[] a, int lo, int mid, int hi){
        //将a[lo, mid]和a[mid+1, hi]归并
        int i = lo, j = mid+1;
        //将a[lo hi]复制到aux[lo hi]
        for (int k = lo; k <= hi; k++){
            aux[k] = a[k];
        }
        //归并到a[lo hi]
        for (int k = lo; k <= hi; k++){
            //如果左半边用尽：
            if (i > mid){
                //取右半边元素：
                a[k] = aux[j++];
            }
            //如果右半边取尽：
            else if (j > hi){
                //取左半边元素：
                a[k] = aux[i++];
            }
            //如果右半边的当前元素小于左半边的当前元素：
            else if (Example.less(aux[j], aux[i])){
                //取右半边元素：
                a[k] = aux[j++];
            }
            //如果右半边的当前元素大于等于左半边的当前元素：
            else{
                //取左半边元素：
                a[k] = aux[i++];
            }
        }
    }

    /**
     * 自顶向下的归并排序
     * 递归的方式
     * @param a 数组a
     */
    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        //递归调用：
        sort(a, 0, a.length - 1);
    }
    private static void sort(Comparable[] a, int lo, int hi){
        //递归的结束条件：
        if (hi <= lo){
            return;
        }
        //中间数mid：
        int mid = lo + (hi - lo)/2;
        //递归过程，调用sort函数，直到到达递归结束条件
        sort(a, lo, mid);
        sort(a, mid+1, hi);
        merge(a, lo, mid, hi);
    }
}
