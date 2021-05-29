package 剑指offer;

/**
 * @author dutu
 * @date 2021-04-07 21:11
 */
public class O18 {
/*    public static ListNode deleteNode(ListNode head, int val) {


        ListNode temp = head;

        while (temp != null){
            System.out.println("--"+temp.val);
            if (temp.val == val) {
                System.out.println("删除");

            }
            temp = temp.next;
        }

        return null;
    }*/

    public static ListNode deleteNode(ListNode head, int val) {
        if(head.val == val) return head.next;
        ListNode pre = head, cur = head.next;
        while(cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if(cur != null) pre.next = cur.next;
        return head;
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        listNode.val = 1;
        ListNode listNode1 = new ListNode();
        listNode1.val = 3;
        ListNode listNode2 = new ListNode();
        listNode2.val = 4;
        listNode.next = listNode1;
        listNode1.next = listNode2;
        deleteNode(listNode,3);
    }
}
