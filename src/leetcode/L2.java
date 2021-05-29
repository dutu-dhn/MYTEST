package leetcode;

import java.util.LinkedList;
import java.util.List;

public class L2 {
    public static void main(String[] args) {
        List operand1List = new LinkedList();
        List operand2List = new LinkedList();
        List resultList = new LinkedList();
        //操作数
        int Operand1 = 342;
        int Operand2 = 465;
        //结果
        int result = Operand2+Operand1;
        change(Operand1,operand1List);
        System.out.println(operand1List.size());

    }
    public static void change(int Operand,List list){
        while(Operand!=0){
            list.add(Operand%10);
            Operand = Operand/10;
        }
    }
}
