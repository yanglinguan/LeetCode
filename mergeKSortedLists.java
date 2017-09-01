/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode node1, ListNode node2) {
                return node1.val - node2.val;
            }
        });
        
        ListNode head = new ListNode(0);
        ListNode cur = head;
        
        for(ListNode node : lists ) {
            if(node != null) {
                minHeap.add(node);
            }
        }
        
        while(!minHeap.isEmpty()) {
            cur.next = minHeap.poll();
            cur = cur.next;
            if(cur.next != null) {
                minHeap.add(cur.next);
            }
        }
        
        return head.next;
    }
}
