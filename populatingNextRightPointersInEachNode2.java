/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        
        Queue<TreeLinkNode> queue = new LinkedList<>();
        
        queue.add(root);
        
        while(!queue.isEmpty()) {
            List<TreeLinkNode> tmp = new ArrayList<TreeLinkNode>();
            while(!queue.isEmpty()) {
                TreeLinkNode t = queue.poll();
                if(queue.isEmpty()) {
                    t.next = null;
                } else {
                    t.next = queue.peek();
                }
                tmp.add(t);
            }
            
            for(TreeLinkNode t : tmp) {
                if(t.left != null) {
                    queue.add(t.left);
                }
                if(t.right != null) {
                    queue.add(t.right);
                }
            }
        }
    }
}
