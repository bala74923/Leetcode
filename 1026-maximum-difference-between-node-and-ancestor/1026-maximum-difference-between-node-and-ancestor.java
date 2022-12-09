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
    public int maxAncestorDiff(TreeNode root) {
        if(root==null) return 0;
        return maxDiff(root,root.val,root.val);
    }
    int maxDiff(TreeNode root,int max,int min){
        if(root==null) return max-min;
        max = Math.max(max,root.val);
        min = Math.min(min,root.val);
        int left = maxDiff(root.left,max,min);
        int right = maxDiff(root.right,max,min);
        int curr =  max-min;
        return Math.max(left,right);
    }
}