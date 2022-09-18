package Trees;

public class _15_Balanced_Binary_ {
    int max = (int)1e9;
    public boolean isBalanced(TreeNode root) {
        return check(root)<max;
    }
    int check(TreeNode root){
        if(root==null)
            return -1;
        int left= check(root.left);
        int right =check(root.right);
        if(Math.abs(left-right)>1)
            return max;
        return Math.max(left,right)+1;
    }
}
