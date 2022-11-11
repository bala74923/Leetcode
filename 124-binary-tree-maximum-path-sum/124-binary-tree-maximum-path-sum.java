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
    int res =0;
    public int maxPathSum(TreeNode root) {
        res = -(int)1e9;
        go(root);
        return res;
    }
     int go(TreeNode root){
        if(root==null) return 0;
        int left = Math.max(go(root.left),0);
        int right= Math.max(go(root.right),0);
        res = Math.max(res,left+right+root.val);
        return Math.max(left,right)+root.val;
    }
}