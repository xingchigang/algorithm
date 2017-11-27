package chapter1;

public class FixedCapacityStack<Item> {
    /**
     * stack entries:
     */
    private Item[] a;
    /**
     * stack size:
     */
    private int N;

    public FixedCapacityStack(int cap){
        a = (Item[]) new Object[cap];
    }

    public void push(Item item){
        a[N++] = item;
    }

    public Item pop(){
        return a[--N];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }
}
