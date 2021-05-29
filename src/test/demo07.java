package test;

import java.util.Scanner;
import java.util.Stack;

//从标准输入后序表达式,求值
//1 4 + 3 * 10 5 / +
//( 1 + 4 ) * 3 + 10 / 5
public class demo07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();

        Stack<Double> values = new Stack<>();
        Stack<String> ops = new Stack<>();

        String[] result = expression.split(" ");

        for (int i = 0;i<result.length;i++){
            if (!result[i].equals("")){
                if (result[i].equals("+")){
                double s1 = values.pop();
                double s2 = values.pop();
                values.push(s2+s1);
            }else if (result[i].equals("-")){
                double s1 = values.pop();
                double s2 = values.pop();
                values.push(s2-s1);
            }else if (result[i].equals("*")){
                double s1 = values.pop();
                double s2 = values.pop();
                values.push(s2*s1);
            }else if (result[i].equals("/")){
                double s1 = values.pop();
                double s2 = values.pop();
                values.push(s2/s1);
            }else {values.push(Double.valueOf(result[i]));}}

        }
        System.out.println(values.size());
        System.out.println(values.pop());
    }
}
