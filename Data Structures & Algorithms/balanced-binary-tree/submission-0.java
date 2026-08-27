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
    public static final int UNBALANCED = -2;
   
    public boolean isBalanced(TreeNode root) {
         return isBalancedOptimized(root);
    }
     public boolean isBalancedOptimized(TreeNode root){
        return checkHeight(root) != UNBALANCED;
    }

    private int checkHeight(TreeNode node){
        if (node == null) return -1;

        int leftHeight = checkHeight(node.left);
        if(leftHeight == UNBALANCED) return UNBALANCED;

        int rightHeight = checkHeight(node.right);
        if(rightHeight == UNBALANCED) return UNBALANCED;

        if (Math.abs(leftHeight -rightHeight)>1) return UNBALANCED;
        return 1+ Math.max(leftHeight, rightHeight);
    }
}
