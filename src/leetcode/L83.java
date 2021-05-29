package leetcode;

public class L83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)return head;
        //查找值
        ListNode search = head;
        while(search!=null&&search.next!=null){
            if (search.val==search.next.val){
                search.next=search.next.next;
            }else search = search.next;
        }

        return  head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.val = 1;
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode search = head;
        while (search!=null){
            System.out.println(search.val);
            head = head.next;
        }
        System.out.println(head.val);
        System.out.println(head.next.val);
        System.out.println(head.next.next.val);
//
//        head.next = head.next.next;
//        System.out.println(head.val);
//        System.out.println(head.next.val);
        //System.out.println(head.next.next.val);

    }
}
