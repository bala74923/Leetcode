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
    public int goodNodes(TreeNode root) {
        return dfs(root,root.val);
    }
    int dfs(TreeNode root,int prev){
        if(root==null) return 0;
        int next = Math.max(prev,root.val);
        return dfs(root.left,next) + 
            dfs(root.right,next) + (prev<=root.val?1:0);
    }
}