package 剑指offer;

import java.util.Stack;

/**
 * @author dutu
 * @date 2021-03-23 20:59
 */
public class O06 {
    public static void main(String[] args) {

    }

    public static int[] reversePrint(ListNode head) {

        Stack<Integer> stack = new Stack<>();

        while (head!=null){
            stack.push(head.val);
            head = head.next;
        }
        int con = stack.size();
        int[] res = new int[con];

        for (int i =0;i<con;i++){
            res[i] = stack.pop();
        }

        return res;

    }



}
