package leetcode;

/**
 * @author dutu
 * @date 2020-11-28 21:01
 */
public class L141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode pre = head;
        ListNode lat = head.next;
        while (pre!=lat){
            if (lat == null || lat.next == null) {
                return false;
            }
            pre = pre.next;
            lat = lat.next.next;
        }
        return true;
    }
}
