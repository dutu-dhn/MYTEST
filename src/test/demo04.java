package test;
//为Stack添加一个方法:返回最近添加元素,而不弹出
public class demo04 {
    public static void main(String[] args) {
        demo04MyStack04 myStack = new demo04MyStack04();
        myStack.push("a");
        myStack.push("b");
        myStack.push("c");
        System.out.println( myStack.mypop());
        System.out.println( myStack.mypop());
    }

}
