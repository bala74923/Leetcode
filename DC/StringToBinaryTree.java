package DC;
class Solution {
    public String tree2str(TreeNode root) {
        if(root==null) return "";
        String left = tree2str(root.left);
        String right = tree2str(root.right);
        String curr = root.val+"";
        if(left.length()!=0 || right.length()!=0)
            curr+= "("+left+")";
        if(right.length()!=0)
            curr+= "("+right+")";
        return curr;
    }
}


