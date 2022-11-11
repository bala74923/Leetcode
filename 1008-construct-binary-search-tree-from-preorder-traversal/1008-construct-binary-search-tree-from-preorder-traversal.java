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
    int index ;
    public TreeNode bstFromPreorder(int[] preorder) {
        index = 0;
        return build(preorder,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    TreeNode build(int[] arr,long left,long right){
        //if satisfies the condition build else terminate this branch
        if(index>=arr.length || arr[index]<left || arr[index]>right)
            return null;
        TreeNode curr= new TreeNode(arr[index++]);
        curr.left = build(arr,left,curr.val);
        curr.right = build(arr,curr.val,right);
        return curr;
    }
}