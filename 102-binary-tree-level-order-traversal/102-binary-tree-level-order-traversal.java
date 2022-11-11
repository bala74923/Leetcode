/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> sub = new ArrayList<>();
            while(size-->0){
                TreeNode front = q.poll();
                sub.add(front.val);
                if(front.left!=null) q.add(front.left);
                if(front.right!=null) q.add(front.right);
            }
            res.add(sub);
        }
        return res;
    }
}