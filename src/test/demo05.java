package test;

import java.util.Scanner;
import java.util.Stack;

//编写一段程序，从标准输人得到一一个缺少左括号的表达式并打印出补全括号之后的中序表述式
// 1+2)*3-4)*5-6)))
public class demo05 {
    public static void main(String[] args) {
        //操作数
        Stack<String> values = new Stack<>();
        //符号
        Stack<String> ops = new Stack<>();
        //键盘输入
        Scanner scanner =new Scanner(System.in);
        String expression = scanner.next();

        for (int i=0;i<expression.length();i++){
            String temp = expression.substring(i,i+1);
            if (temp.equals("+")) ops.push(temp);
            else if (temp.equals("-")) ops.push(temp);
            else if (temp.equals("*")) ops.push(temp);
            else if (temp.equals("/")) ops.push(temp);
            else if (temp.equals(")")){
                String s1 = values.pop();
                String s2 = values.pop();
                String s3 = ops.pop();

                String s = "("+s2+s3+s1+")";
                values.push(s);

            }
            else values.push(temp);
        }
        System.out.println(values.pop());
    }
}
