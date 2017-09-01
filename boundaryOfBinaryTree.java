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
    
    private class Wrap {
        TreeNode node;
        int level;
        Wrap(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
    
    private List<Integer> helper(TreeNode root, boolean isLeft) {
        if(root == null) return new ArrayList<Integer>();
        Deque<Wrap> stack = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        stack.push(new Wrap(root, 0));
        int maxLevel = -1;
        while(!stack.isEmpty()) {
            Wrap top = stack.pop();
            if(top.level > maxLevel || (top.node.left == null && top.node.right == null)) {
                result.add(top.node.val);
            }
            maxLevel = Math.max(maxLevel, top.level);
            if(isLeft) {
                
                if(top.node.right != null) {
                    stack.push(new Wrap(top.node.right, top.level + 1));
                }
                if(top.node.left != null) {
                    stack.push(new Wrap(top.node.left, top.level + 1));
                }
                
                
            } else {
                
                if(top.node.left != null) {
                    stack.push(new Wrap(top.node.left, top.level + 1));
                }
                if(top.node.right != null) {
                    stack.push(new Wrap(top.node.right, top.level + 1));
                }
                
                
                
            }
        }
        
        return result;
    }
    
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();
        List<Integer> result = new ArrayList<Integer>();
        result.add(root.val);
        List<Integer> left = helper(root.left, true);
        result.addAll(left);
        List<Integer> right = helper(root.right, false);
        for(int i = right.size() - 1; i >=0; i--) {
            result.add(right.get(i));
        }
        return result;
    }
}
