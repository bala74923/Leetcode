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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        int level=0;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list=  new ArrayList<>();
            while(size-->0){
                TreeNode front = q.poll();
                if(level%2==0)  list.add(front.val);
                else list.add(0,front.val);
                if(front.left!=null) q.add(front.left);
                if(front.right!=null) q.add(front.right);
            }
            res.add(list);
            ++level;
        }
        return res;
    }
}