package chapter1;


public class Test {
    public static void main(String[] args){
        Comparable[] a = {0,1,2,3,4,5,6,7,8,9};
        Comparable i = a[0];
        Comparable j = a[1];
        int count = 0;
        while (less(i, j)) {
            System.out.print("a" + " ");
            count++;
            if (count >= 10){
                break;
            }

        }
    }
    public static boolean less(Comparable i, Comparable j){
        return i.compareTo(j) < 0;
    }
}
