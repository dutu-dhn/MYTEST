package 剑指offer;

import java.util.Stack;

/**
 * @author dutu
 * @date 2021-04-11 14:00
 */
public class O30 {
    public O30(){

    }

    Stack<Integer> a = new Stack<>();
    Stack<Integer> b = new Stack<>();

    public void push(int x) {
        a.push(x);
        if (b.isEmpty()){
            b.push(x);
        }else {
            if (x<b.peek()){
                b.push(x);
            }else {
                b.push(b.peek());
            }
        }
    }

    public void pop() {


        a.pop();
        b.pop();
    }

    public int top() {
        return a.peek();
    }

    public int min() {
        return b.peek();
    }

    public static void main(String[] args) {
        O30 s1 = new O30();
        s1.push(1);
        System.out.println("min---"+s1.min());
        s1.push(0);
        System.out.println("min---"+s1.min());
        s1.push(2);
        s1.pop();
        System.out.println("min---"+s1.min());

    }
}
