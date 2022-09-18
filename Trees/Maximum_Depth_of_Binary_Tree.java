package Trees;

public class Maximum_Depth_of_Binary_Tree {
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right)+1;
    }
}
