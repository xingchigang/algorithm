package chapter1;

public class UnionFind {
    private int[] id;
    private int count;

    /**
     * 初始化，调用时，构造一个长度为N，从0——N-1的数组
     * @param N
     */
    public UnionFind(int N){
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++){
            id[i] = i;
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
        //如果p和q已经在相同的分量中，则不需要采取任何行动
        if (pID == qID){
            return;
        }
        //将p的分量重命名为q的名称
        for (int i = 0; i < id.length; i++){
            if (id[i] == pID){
                id[i] = qID;
            }
        }
        count--;
    }
    public int find(int p){
        return id[p];
    }
    public boolean connected(int p, int q){
        return find(p) == find(q);
    }
    public int count(){
        return count;
    }
}
