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
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        return go(root.left,Long.MIN_VALUE,root.val) && go(root.right,root.val,Long.MAX_VALUE);
    }
    boolean go(TreeNode root,long left,long right){
        if(root==null) return true;
        return go(root.left,left,root.val) && go(root.right,root.val,right) && left<root.val && root.val<right;
    }
}