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
    Map<Integer,Integer> map;
    int index ;
    int[] preorder,inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        this.preorder = preorder;
        this.inorder  = inorder;
        index =0;
        return build(0,inorder.length-1);
    }
    TreeNode build(int lo,int hi){
        if(lo>hi) return null;
        int tind=  map.get(preorder[index]);
        TreeNode curr = new TreeNode(preorder[index++]);
        curr.left = build(lo,tind-1);
        curr.right=  build(tind+1,hi);
        return curr;
    }
}