package chapter1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Parentheses判断括号是否成对完整，例如：
 * 【】输出true，{}(输出false
 * 解决思路：
 * 使用栈（stack），读入字符串，如果是左括号，入栈，如果是右括号则出栈，检测栈是否为空，为空则是true
 * 否则为false。
 * API：isEmpty();push();pop()
 */
public class Parentheses {
    public static void main(String[] args){
        Stack<String> left = new Stack<>();
        Stack<String> right = new Stack<>();
        String input = StdIn.readString();
        while (!StdIn.isEmpty()){
            if (input.equals("{") || input.equals("[") || input.equals("(")){
                left.push(input);
            }
            else if (input.equals("}") || input.equals("]") || input.equals(")")){
                right.push(input);
            }
        }
        if (left.size() == right.size()){
            StdOut.println("true");
        }
        else {
            StdOut.println("false");
        }
    }
}
