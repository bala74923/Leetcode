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
class Pair{
    int d;
    TreeNode par;
    Pair(int d,TreeNode par){this.d = d;this.par =par;}
}
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Pair p1= get(root,x,0,null),p2 = get(root,y,0,null);
        return p1.d==p2.d && p1.par!=p2.par;
    }
    Pair get(TreeNode root,int x,int d,TreeNode parent){
        if(root==null) return null;
        if(root.val==x){
            return new Pair(d,parent);
        }
        Pair left = get(root.left,x,d+1, root);
        Pair right = get(root.right,x,d+1, root);
        return left!=null?left:right;
    }
}