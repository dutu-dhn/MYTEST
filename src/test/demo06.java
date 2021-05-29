package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//把算数表达式中序转后序
// ( 1 + 4 ) * 3 + 10 / 5
// 1 4 + 3 *  10 5 / +
// (((1+4)*3)+(10/5))
// ((1+2)*((3-4)*5-6)))
public class demo06 {
    public static void main(String[] args) {
        //符号
        demo04MyStack04<String> ops = new demo04MyStack04<>();
        //操作数
        Queue<String> values = new LinkedList<>();
        //键盘输入
        Scanner scanner =new Scanner(System.in);
        String expression = scanner.nextLine();
        String k = " ";
        String[] t = expression.split(k);
        for (String  s:t
             ) {
            System.out.println(s);
        }

        for (int i=0;i<t.length;i++){
            if (!t[i].equals("")) {
                if (t[i].equals("(")){ops.push("(");}
                else if (t[i].equals(")")){
                    String temp = ops.mypop();
                    while(!("(").equals(temp)){
                        values.add(ops.pop());
                        temp=ops.mypop();
                    }
                    if (ops.mypop().equals("(")){
                        ops.pop();
                    }
                }
                else  if (t[i].equals("+")|t[i].equals("-")|t[i].equals("*")|t[i].equals("/")){
                    if (ops.size()!=0){
                        if (ops.mypop().equals("(")){
                            ops.push(t[i]);
                        }else{
                            if (priority(t[i],ops.mypop())){
                                ops.push(t[i]);
                            }else{
                                //栈顶入队
                                values.add(ops.pop());
                                ops.push(t[i]);
                            }
                        }

                    }else{
                        ops.push(t[i]);
                    }

                }
                else values.add(t[i]);
            }
        }
        if (ops.size()>0){
            int size = ops.size();
            for (int j=0;j<size;j++){
                values.add(ops.pop());
            }
        }
        for (String s:values
             ) {
            if (!s.equals("(")) System.out.print(s+" ");
        }

    }
//小于false,大于=true
    public static boolean priority(String s1,String s2){
        int t1=0;
        int t2=0;
        if (s1.equals("+")|s1.equals("-")){
            t1=0;
        }
        if (s2.equals("+")|s2.equals("-")){
            t2=0;
        }
        if (s1.equals("*")|s1.equals("/")){
            t1=1;
        }
        if (s2.equals("*")|s2.equals("/")){
            t2=1;
        }
        return t1>t2;
    }

}
