public class Solution {
    public static boolean validateBST(BinaryTreeNode<Integer> root) {
        // Write your code here
       return go(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    static boolean go(BinaryTreeNode<Integer> root,int start,int end){
        if(root==null) return true;
        return start<=root.data && root.data<=end && go(root.left,start,root.data) && go(root.right,root.data,end);
    }