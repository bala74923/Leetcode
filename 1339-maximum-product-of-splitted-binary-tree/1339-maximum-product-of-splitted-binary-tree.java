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
    int mod = (int)1e9+7;
    long ans = -1L;
    public int maxProduct(TreeNode root) {
        ans = -1;
        long tot = sum(root);
        go(root,tot);
        return (int)(ans%mod);
    }
    long go(TreeNode root,long sum){
        if(root==null) return 0;
        long curr = go(root.left,sum)+go(root.right,sum) + root.val;
        ans = Math.max(ans,curr*(sum-curr));
        return curr;
    }
    long sum(TreeNode root){
        return root==null?0: root.val+sum(root.left)+sum(root.right);
    }
}