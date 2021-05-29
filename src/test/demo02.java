package test;

import java.util.Scanner;
import java.util.Stack;

//算数表达式求值
public class demo02 {
    public static void main(String[] args) {
        //操作数栈
        Stack<Double> values = new Stack<>();
        //符号栈
        Stack<String> ops = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.next();
        System.out.println(expression.length());
        for (int i = 0;i<expression.length();i++){
            String temp = expression.substring(i,i+1);
            System.out.println(temp);
            if (temp.equals("("));
            else if (temp.equals("+")) ops.push(temp);
            else if (temp.equals("-")) ops.push(temp);
            else if (temp.equals("*")) ops.push(temp);
            else if (temp.equals("/")) ops.push(temp);
            else if (temp.equals(")")){
                String op = ops.pop();
                double value = values.pop();
                if (op.equals("+")) value = values.pop() + value;
                else if (op.equals("-")) value = values.pop() - value;
                else if (op.equals("*")) value = values.pop() * value;
                else if (op.equals("/")) value = values.pop() / value;
                values.push(value);
            }
            else values.push(Double.parseDouble(temp));
        }
        System.out.println(values.pop());
    }
}
