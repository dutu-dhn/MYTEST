package leetcode;

import edu.princeton.cs.algs4.Stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author dutu
 * @date 2020-11-29 15:06
 */
public class L155 {
    private int[] l = null;
    //当前数组存储的位置范围0--l.length-1
    private int index = -1;
    int min;
    Stack<Integer> lmin = new Stack<>();
    public L155() {
        l = new int[10];
    }

    public void push(int x) {
        if (index==-1){
            min = x;
            lmin.push(min);
        }
        else {
            if(min>x){
                lmin.push(x);
            }else {
                lmin.push(lmin.peek());
            }
        }
        if (index>= l.length/2){
            int[] temp = new int[l.length*2];
            for (int i = 0; i < l.length; i++) {
                temp[i] = l[i];
            }
            l = temp;
        }
        l[++index] = x;

    }
    public void sou(){
        for (int i : l) {
            System.out.print(i+"--");
        }
        System.out.println();
        for (Integer integer : lmin) {
            System.out.print(integer+"==");
        }
    }
    public void pop() {
        if (index>=0){
            if (!lmin.isEmpty()){
                if (l[index]==lmin.peek()){
                    lmin.pop();
                }
            }
            l[index] = 0;
            System.out.println("前"+index);
            index--;
            System.out.println("后"+index);
        }

    }

    public int top() {
        if (index>=0){
            return l[index];
        }
       return -1;
    }

    public int getMin() {
        if (lmin.isEmpty()){
            return l[index];
        }
        return lmin.peek();
    }

    public static void main(String[] args) {
        L155 l = new L155();
        l.push(-2);
        l.push(0);
        l.push(3);
        l.pop();
        l.top();


        System.out.println(l.getMin());
        l.sou();


    }
}
class MinStack {
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public MinStack() {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
