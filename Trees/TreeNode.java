package Trees;

public class TreeNode {
    int val;
    TreeNode left,right;
    TreeNode(int val){
        this.val = val;
        left = right = null;
    }
    static TreeNode getTreeFromArray(int[] arr){
        return  CreateNode(arr,0);
    }
    static TreeNode CreateNode(int[] arr,int index){
        if(index>=arr.length || arr[index]==-1) return null;
        TreeNode curr = new TreeNode(arr[index]);
        curr.left = CreateNode(arr,2*index+1);
        curr.right = CreateNode(arr,2*index+2);
        return curr;
    }
}