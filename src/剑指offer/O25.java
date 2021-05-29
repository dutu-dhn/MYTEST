package 剑指offer;

/**
 * @author dutu
 * @date 2021-04-09 20:21
 */
public class O25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode res = new ListNode(0), cur = res;

        while (l1 != null && l2 !=null){
            if (l1.val <= l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }

            cur = cur.next;
        }

        cur.next = l1 != null ? l1 : l2;
        return res.next;
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            return l1 != null ? l1 : l2;
        }
        if(l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

}
