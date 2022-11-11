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
    public void flatten(TreeNode root) {
        go(root);
    }
    TreeNode go(TreeNode root){
        if(root==null) return null;
        TreeNode lend = go(root.left);
        TreeNode rend = go(root.right);
       // System.out.print(root.val+"=>");
        //System.out.print(lend!=null?lend.val+"-":"null-");
       // System.out.println(rend!=null?rend.val+"-":"null-");
        
        
        if(lend!=null){
            lend.right = root.right;
            root.right = root.left;
        }
        root.left = null;
        return rend==null?(lend!=null?lend:root):rend;
    }
}