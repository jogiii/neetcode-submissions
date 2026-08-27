/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

     public boolean isBalanced(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        boolean balanced = true;

        if (root != null) {
            stack.push(root);
        }

        while (!stack.isEmpty() && balanced) {
            TreeNode node = stack.peek();

            if (node.left != null && !map.containsKey(node.left)) {
                stack.push(node.left);
            } else if (node.right != null && !map.containsKey(node.right)) {
                stack.push(node.right);
            } else {
                stack.pop();
                int leftDepth = map.getOrDefault(node.left, 0);
                int rightDepth = map.getOrDefault(node.right, 0);

                if (Math.abs(leftDepth - rightDepth) > 1) {
                    balanced = false; // short-circuit
                    break;
                }
                map.put(node, 1 + Math.max(leftDepth, rightDepth));
            }
        }
        return balanced;
    }
}
