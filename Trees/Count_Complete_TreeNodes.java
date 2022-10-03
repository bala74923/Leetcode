package Trees;

public class Count_Complete_TreeNodes {
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int lh = leftHeight(root), rh= rightHeight(root);
        return lh==rh?(1<<lh)-1:
                1+ countNodes(root.left)+ countNodes(root.right);
    }
    static int leftHeight(TreeNode root){
        if(root==null) return 0;
        return 1+ leftHeight(root.left);
    }
    static int rightHeight(TreeNode root){
        if(root==null) return 0;
        return 1+ rightHeight(root.right);
    }
}
