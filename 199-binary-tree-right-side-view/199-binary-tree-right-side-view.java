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
    List<Integer> list;
    // find the depth do with pre order traversal
    public List<Integer> rightSideView(TreeNode root) {
        list =  new ArrayList<>();
        go(0,root);
        return list;
    }
     void go(int depth,TreeNode root){
        if(root==null) return ;
        // add or change the list
        if(depth>=list.size()) list.add(root.val);
        else list.set(depth,root.val);
        go(depth+1,root.left);
        go(depth+1,root.right);
    }
    
}