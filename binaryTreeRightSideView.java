/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        while(!queue.isEmpty()) {
            List<TreeNode> level = new ArrayList<>();
            while(!queue.isEmpty()) {
                level.add(queue.poll());
            }
            result.add(level.get(level.size() - 1).val);
            for(TreeNode i : level) {
                if(i.left != null) {
                    queue.add(i.left);
                }
                if(i.right != null) {
                    queue.add(i.right);
                }
            }
        }
        return result;
        
    }
}
