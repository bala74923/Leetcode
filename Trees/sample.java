package Trees;

public class sample {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,-1,5,6,-1,-1,-1,-1,-1,-1,-1,-1};
        TreeNode node = TreeNode.getTreeFromArray(arr);
        preOrder(node);
    }
    static void preOrder(TreeNode node){
        if(node==null) return;
        System.out.println(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }
}
