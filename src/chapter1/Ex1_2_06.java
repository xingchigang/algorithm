package chapter1;

import edu.princeton.cs.algs4.StdOut;

public class Ex1_2_06 {
    public static void main(String[] args){
        String string1 = "actgacg";
        String string2 = "tgacgac";
        if (string1.length() == string2.length() && string1.concat(string1).indexOf(string2) >= 0 ){
            StdOut.println("True");
            StdOut.println(string1.concat(string1));
            StdOut.println(string1.concat(string1).indexOf(string2));
            StdOut.println(string1.indexOf(string2));
        }
        else{
            StdOut.println("False");
        }
    }
}
