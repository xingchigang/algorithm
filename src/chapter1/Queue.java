package chapter1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Queue<Item> {
    private Node first;
    private Node last;
    private int N;
    private class Node{
        Item item;
        Node next;
    }

    /**
     * 判断queue是否为空
     * @return
     */
    public boolean isEmpty(){
        return first == null;
    }

    /**
     * 获取queue的大小
     * @return
     */
    public int size(){
        return N;
    }
    /**
     * 成队列，在链表的尾添加元素
     * 1.将原有的last保存为oldlast
     * 2.新的item赋值给last
     * 3.oldlast指向last
     */
    public void enqueue(Item item){
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()){
            first = last;
        }
        else {
            oldlast.next = last;
        }
    }
    /**
     * 出栈，在链表头删除元素
     * 将first指向first.next
     */
    public Item dequeue(){
        Item item = first.item;
        first = first.next;
        if (isEmpty()){
            last = null;
        }
        N--;
        return item;
    }
    public static void main(String[] args){
        Queue<String> q = new Queue<String>();
        while (!StdIn.isEmpty()){
            String str = StdIn.readString();
            StdOut.println(str.length());
            if (!str.equals("-")){
                q.enqueue(str);
            }
            else if (!q.isEmpty()){
                StdOut.println("(" + q.dequeue() + " " + "left on queue)");
            }
        }
    }
}
