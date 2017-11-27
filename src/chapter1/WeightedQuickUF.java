package chapter1;

public class WeightedQuickUF {
    /**
     * 父链接数组，由触点索引：
     */
    private int[] id;
    /**
     * 各个根节点所对应的分量大小，由触点索引：
     */
    private int[] sz;
    /**
     * 连通分量的数量
     */
    private int count;

    /**
     * 初始化，调用时，构造一个长度为N，从0——N-1的数组
     * @param N
     */
    public WeightedQuickUF(int N){
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++){
            id[i] = i;
        }
        sz = new int[N];
        for (int i = 0; i < N; i++){
            sz[i] = 1;
        }

    }

    /**
     * 将p和q归并到相同的分量中
     * @param p
     * @param q
     */
    public void union(int p, int q){
        int pID = find(p);
        int qID = find(q);
        //将小树的根节点连接到大树的根节点
        if (pID == qID){
            return;
        }
        //将p的分量重命名为q的名称
        if (sz[pID] < sz[qID]){
            id[pID] = qID;
            sz[qID] += sz[pID];
        }
        else {
            id[qID] = pID;
            sz[pID] += sz[qID];
        }
        count--;
    }
    public int find(int p){
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }
    public boolean connected(int p, int q){
        return find(p) == find(q);
    }
    public int count(){
        return count;
    }
}
