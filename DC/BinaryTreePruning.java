package DC;
class  BinaryTreePruning {
    
    public TreeNode pruneTree(TreeNode root) { //0ms
        boolean ok = go(root,null);
        return ok?root:null;
    }
    static boolean go(TreeNode root,TreeNode parent){
        if(root==null)
            return false;
        boolean left = go(root.left,root),right = go(root.right,root);
        if(left||right||root.val==1) {
            if(!left) root.left = null;
            if(!right) root.right=null;
            return true;
        } 
       return false;
    }
}