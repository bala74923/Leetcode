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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return getList(root1).equals(getList(root2));
    }
    List<Integer> list;
    List<Integer> getList(TreeNode root){
        list = new ArrayList<>();
        go(root);
        return list;
    }
    void go(TreeNode root){
        if(root==null) return ;
        if(root.left==root.right) list.add(root.val);
        go(root.left);
        go(root.right);
    }
}