package leetcode;

import java.util.LinkedList;

public class L21 {
    public static LinkedList<Integer> mergeTwoLists(LinkedList<Integer> l1, LinkedList<Integer> l2) {

        //判空
        if(l1==null&&l2!=null) return l2;
        if(l1!=null&&l2==null) return l1;
        if(l1==null&&l2==null) return l1;
        //结果
        LinkedList<Integer> res = new LinkedList<>();
        while(l1.size()!=0&&l2.size()!=0){
            if (l1.getFirst()>=l2.getFirst()) res.add(l2.remove());
            else res.add(l1.remove());
        }
        if (l1.size()!=0){
            for (int i:l1
                 ) {
                res.add(i);
            }
        }else if(l2.size()!=0){
            for (int i:l2
            ) {
                res.add(i);
            }
        }
        for (int i:res
             ) {
            System.out.println(i);
        }
        return res;
    }

    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<>();
        LinkedList<Integer> l2 = new LinkedList<>();
        l1.add(1);
        l1.add(2);
        l1.add(4);
        l1.add(5);

        l2.add(10);
        l2.add(30);
        l2.add(40);
        mergeTwoLists(l1,l2);
        //System.out.println(l1.getFirst());

    }
}
