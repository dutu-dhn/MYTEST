package test;

import java.util.LinkedList;

//编写一个delete方法,接收参数,int K,删除链表的第k个元素
public class demo11 {
    public  static boolean delete(LinkedList<String> linkedList, int k){
        int index = 0;
        if (k>linkedList.size()) {return false;}
        for (String s:linkedList
             ) {
            if (index==k) {linkedList.remove(s);
                System.out.println("删除-->"+s);return true;}
            index++;
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("d");
        linkedList.add("e");
        System.out.println(linkedList.remove(2));
//        System.out.println(linkedList.size());
//        System.out.println("删除-->"+delete(linkedList,2));
//        System.out.println(linkedList.size());
    }
}
