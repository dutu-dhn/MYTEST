package 剑指offer;

/**
 * @author dutu
 * @date 2021-04-09 19:44
 */
public class O24N {
    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode temp = head;

        while (temp != null){
            ListNode next = temp.next;
            temp.next = pre;
            pre = temp;
            temp = next;
        }
        return pre;
    }


}
