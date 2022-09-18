package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightView {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q =   new LinkedList<>();
        q.add(root);
        List<Integer> list = new ArrayList<>();
        if(root==null) return list;
        while(!q.isEmpty()){
            int size = q.size();
            int last =  -1;
            /*
             list .add(q.peek().val) for left side view
             */
            for(int i=0;i<size;i++){
                TreeNode front = q.poll();
                last = front.val;
                if(front.left!=null) q.add(front.left);
                if(front.right!=null) q.add(front.right);
            }
            list.add(last);
        }
        return list;
    }
}
