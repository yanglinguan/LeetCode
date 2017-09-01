public class Solution {
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode list = new ListNode(0);
        ListNode head = list;
        
        while(l1 != null || l2 != null) {
            if(l1 == null) {
                list.next = new ListNode(l2.val);
                l2 = l2.next;
            } else if(l2 == null) {
                list.next = new ListNode(l1.val);
                l1 = l1.next;
            } else if(l1.val <= l2.val) {
                list.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                list.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            list = list.next;
        }
        return head.next;
    }
    
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slowParent = head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slowParent = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        slowParent.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        
        return mergeTwoLists(left, right);
        
        
      
        
    }
}
