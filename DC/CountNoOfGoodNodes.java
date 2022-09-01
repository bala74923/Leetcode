package DC;
/**
 * CountNoOfGoodNodes
 */
public class CountNoOfGoodNodes {

    public static void main(String[] args) {

    }
    public static int goodNodes(TreeNode root) { //4ms
        return f(root,Integer.MIN_VALUE);
    }
    static int f(TreeNode root,int max){
        if(root==null) return 0;
        return f(root.left,Math.max(max,root.val)) +
            f(root.right,Math.max(max,root.val)) + (max<=root.val?1:0);
    }
}

  class TreeNode {
     int val;
    TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 