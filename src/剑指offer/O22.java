package 剑指offer;

/**
 * @author dutu
 * @date 2021-04-08 15:20
 */
public class O22 {
    public static ListNode getKthFromEnd(ListNode head, int k) {

        ListNode temp = head;

        int size = 0;
        while (temp != null){
            temp = temp.next;
            size++;
        }



        while (head != null){
            if (size == k) return temp = head;
            head = head.next;
            size--;
        }
        return head;

    }

    // 双指针
    public ListNode getKthFromEnd1(ListNode head, int k) {
        ListNode former = head, latter = head;
        for(int i = 0; i < k; i++)
            former = former.next;
        while(former != null) {
            former = former.next;
            latter = latter.next;
        }
        return latter;
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

        ListNode kthFromEnd = getKthFromEnd(listNode, 3);
        System.out.println(kthFromEnd.val);
    }
}
