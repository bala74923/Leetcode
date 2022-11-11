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
    public TreeNode balanceBST(TreeNode root) {
        list = new ArrayList<>();
        addList(root);
        return build(root,0,list.size()-1,list);
    }
    TreeNode build(TreeNode root,int lo,int hi,List<Integer> list){
        if(lo==hi) return new TreeNode(list.get(lo));
        if(lo>hi) return null;
        int mid = (lo+hi)>>1;
        TreeNode curr = new TreeNode(list.get(mid));
        curr.left = build(root,lo,mid-1,list);
        curr.right = build(root,mid+1,hi,list);
        return curr;
    }
    void addList(TreeNode root){
        if(root==null) return;
        addList(root.left);
        list.add(root.val);
        addList(root.right);
    }
}