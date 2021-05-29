package test;

//编写Stack的用例,从标准输入中读取一个文本流并使用栈判定其中的括号是否配对完整

import java.util.Scanner;
import java.util.Stack;

public class demo03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();

        Stack<String> ops = new Stack<>();

        for (int i = 0;i<text.length();i++){
            String temp = text.substring(i,i+1);
            if (temp.equals("(")) ops.push(temp);
            else if (temp.equals("{")) ops.push(temp);
            else if (temp.equals("[")) ops.push(temp);
            else if (temp.equals("<")) ops.push(temp);
            else if (temp.equals(")")) {
                if (!ops.pop().equals("(")) {
                    System.out.println(false);
                    return;
                }
                }
            else if (temp.equals("}")) {
                if (!ops.pop().equals("{")) {
                    System.out.println(false);
                    return;
                }
            }
            else if (temp.equals("]")) {
                if (!ops.pop().equals("[")) {
                    System.out.println(false);
                    return;
                }
            }
            else if (temp.equals(">")) {
                if (!ops.pop().equals("<")) {
                    System.out.println(false);
                    return;
                }
            }

        }
        System.out.println(ops.isEmpty());

    }
}
