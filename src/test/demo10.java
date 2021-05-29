package test;
//编写一个方法find,接受一个链表和一个key,判断链表中是否有key
import java.util.LinkedList;

public class demo10 {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        System.out.println(find(linkedList,"b"));


    }
    public static boolean find(LinkedList<String> linkedList,String key){

        for (String s:linkedList
             ) {
            System.out.println(s);
            if (s.equals(key)) return true;
        }
        return false;
    }
}
