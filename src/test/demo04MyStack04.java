package test;

import java.util.Stack;

public class demo04MyStack04<E> extends Stack<E> {
    public E mypop(){
        E obj = pop();
        push(obj);
        return obj;
    }
}
