package Trees;

import java.util.ArrayList;
class TreeNode2 {
    int data;
    TreeNode2 left;
    TreeNode2 right;

    TreeNode2(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

}
public class Boundary_order {
    static ArrayList<Integer> list;
    public static  ArrayList<Integer> traverseBoundary(TreeNode2 root){
        // Write your code here.
        list=  new ArrayList<>();
        list.add(root.data);
        goLeft(root.left);
        //System.out.println(list);
        if(!isLeaf(root))
            go(root);
        goRight(root.right);
        return list;
    }
    static void go(TreeNode2 root){
        if(root==null) return ;
        if(isLeaf(root)) {
            list.add(root.data);
            return;
        }
        go(root.left);
        go(root.right);
    }
    static void goLeft(TreeNode2 root){
        //System.out.println(root.data+"=> left"+root.left.data);
        if(root==null || isLeaf(root)) return;
        // System.out.println(root.data+"=> left");
        list.add(root.data);
        if(root.left!=null) goLeft(root.left);
        else goLeft(root.right);
    }
    static void goRight(TreeNode2 root){
        if(root==null || isLeaf(root)) return;
        if(root.right!=null) goRight(root.right);
        else goRight(root.left);
        list.add(root.data);
    }
    static boolean isLeaf(TreeNode2 root){
        return root.left==null && root.right==null;
    }
}
