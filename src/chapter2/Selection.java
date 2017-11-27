package chapter2;

/**
 * Selection——选择排序：
 * 1.找到数组中最小的那个元素
 * 2.将它和数组第一个元素交换
 * 3.找到剩余数组中的最小元素，将它与数组第2个元素交换
 */
public class Selection {
    public static void sort(Comparable[] a){
        int N = a.length;
        for (int i = 0; i < N; i++){
            //初始化min（这里是索引号）为数组的第一个元素：
            int min = i;
            //遍历数组中剩余的元素：
            for (int j =i+1; j < N; j++){
                //这里的比较方法使用Comparable中的compareTo方法
                //如果元素小于现在的最小值，则将此元素设置为新的最小值：
                if (Example.less(a[j], a[min])){
                    min = j;
                }
            }
            //将最小值和第一个没有排序过的位置交换：
            Example.exch(a, i, min);
        }
    }
}
