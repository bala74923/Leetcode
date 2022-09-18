package Trees;

import java.util.*;

class BinaryTreeNode {
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
class Node1{
    BinaryTreeNode root;
    int pos;
    Node1(BinaryTreeNode root,int pos){
        this.root =  root;
        this.pos = pos;
    }
    public String toString(){
        return "val = "+this.root.val+",pos  ="+this.pos;
    }
}
public class TopView {
    public static ArrayList<Integer> getTopView(BinaryTreeNode root) {
        // Write your code here.
        ArrayList<Integer> list = new ArrayList<>();
        if(root==null) return list;
        Map<Integer,Integer> map =  new TreeMap<>();
        Queue<Node1> q = new LinkedList<>();
        q.add(new Node1(root,0));
        while(!q.isEmpty()){
            //System.out.println(q);
            Node1 front = q.poll();
            if(map.get(front.pos)==null)// remove this condition then it is bottom view
                map.put(front.pos,front.root.val);
            if(front.root.left!=null) q.add(new Node1(front.root.left,front.pos-1));
            if(front.root.right!=null) q.add(new Node1(front.root.right,front.pos+1));
        }
        //System.out.println(map);
        for(int key:map.keySet()){
            list.add(map.get(key));
        }
        return list;
    }
}
