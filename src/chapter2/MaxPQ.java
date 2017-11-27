package chapter2;

/**
 * 基于堆的优先队列
 * 解决的问题：对优先队列API的实现能够保证插入元素和删除最大元素这个两个操作的用时和队列大小仅成对数关系。
 * @author xingchigang
 * @param <Key>
 * 二叉堆：一组能够用堆有序的完全二叉树排序的元素，并在数组中按照层级存储（不适用数组的第一个位置）
 * 因此需要存储一个大小为N的堆，需要一个N+1大小的数组
 * 在一个堆中，k节点的父节点为[k/2],其子节点为2k或2k+1;
 * a[k]向上一层的操作为令k = k/2，向下一层的操作为令k = 2k或2k+1
 */
public class MaxPQ<Key extends Comparable<Key>> {
    /**
     * 基于堆的完全二叉树，存储于pq[1,N]中，pq[0]没有使用
     */
    private Key[] pq;
    private int N = 0;

    /**
     * less()函数为i小于j时为真；
     * @param i
     * @param j
     * @return
     */
    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j]) < 0;
    }

    /**
     * 交换i，j两个位置的元素值；
     * @param i
     * @param j
     */
    private void exch(int i, int j){
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    /**
     * swim()：由下自上的堆有序化（上浮），某个节点变得比父节点更大
     * @param k
     */
    private void swim(int k){
        while (k > 1 && less(k/2, k)){
            exch(k/2, k);
            k = k/2;
        }
    }

    /**
     * sink()：由上至下的堆有序化（下沉），某个节点变得比它的两个子节点或是其中之一更小
     * @param k
     */
    private void sink(int k){
        while (2*k <= N){
            int j = 2*k;
            if (j < N && less(j, j+1)){
                j++;
            }
            if (!less(k,j)){
                break;
            }
            exch(k, j);
            k = j;
        }
    }


    public MaxPQ (int max_n){
        pq = (Key[]) new Comparable[max_n+1];
    }
    public boolean isEmpty(){
        return N == 0;
    }
    public int size(){
        return N;
    }

    /**
     * 插入元素v，将新元素加到数组的末尾，增加堆的大小并让这个新元素上浮到合适的位置
     * @param v
     */
    public void insert(Key v){
        pq[++N] = v;
        swim(N);
    }

    /**
     * 删除最大元素（有序的二叉堆最大元素就是pq[1]）从数组顶端删除最大的元素，并将数组的最后一个元素放到
     * 顶端，减小堆的大小，并让这个元素下沉到最合适的位置。
     * @return
     */
    public Key delMax(){
        //从根节点得到最大元素
        Key max = pq[1];
        //将其和最后一个节点交换
        exch(1, N--);
        //防止对象游离
        pq[N+1] = null;
        //恢复堆的有序性
        sink(1);
        return max;
    }
}
