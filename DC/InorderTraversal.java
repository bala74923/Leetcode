package DC;
import java.util.ArrayList;
import java.util.List;

class InorderTraversal {
   List<Integer> list ;
    public List<Integer> inorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        go(root);
        return list;
    }
    void go(TreeNode root){
        if(root==null) return;
        go(root.left);
        list.add(root.val);
        go(root.right);
    }
}

