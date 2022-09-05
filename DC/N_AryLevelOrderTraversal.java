package DC;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * N-AryLevelOrderTraversal
 */
public class N_AryLevelOrderTraversal {

    public static void main(String[] args) {
        
    }
    public List<List<Integer>> levelOrder(Node root) { //7ms
        List<List<Integer>> list = new ArrayList<>();
        if(root==null) return list;
        Queue<Node> q = new LinkedList<>();q.add(root);
        while(!q.isEmpty()){
            List<Integer> sub = new ArrayList<>();
            int size = q.size();
            for(int i=0;i<size;i++){
                Node front = q.poll();
                sub.add(front.val);
                for(Node child:front.children){
                    q.add(child);
                }
            }
            list.add(sub);
        }
        return list;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}