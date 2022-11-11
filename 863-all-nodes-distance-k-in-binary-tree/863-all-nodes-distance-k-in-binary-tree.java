/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<List<Integer>> list = toGraph(root);
        
        boolean[] visited = new boolean[501];
        
        Queue<Integer> q= new LinkedList<>();
        q.add(target.val);
        visited[target.val] = true;
        
        int level =1;
        while(!q.isEmpty() && level<=k){
            int size  = q.size();
            System.out.println(q);
            while(size-->0){
                int front = q.poll();
                //System.out.printf("child [%d] =%s\n",front,list.get(front));
                // visit all unvisited nodes
                for(int child: list.get(front)){
                    if(!visited[child]){
                        q.add(child);
                        visited[child] = true;
                    }
                }
            }
            ++level;
        }
        return new ArrayList<>(q);
    }

    List<List<Integer>> graph;
    List<List<Integer>> toGraph(TreeNode root){
        graph = new ArrayList<>();
        for(int i=0;i<=500;i++)// max of node val is 500
            graph.add(new ArrayList<>());
        dfs(root);
        return graph;
    }
    void dfs(TreeNode root){
        if(root==null) return ;
        int rv=  root.val;
        if(root.left!=null){
            int rlv = root.left.val;
           graph.get(rlv).add(rv);
            graph.get(rv).add(rlv);
        }
        if(root.right!=null){
            int rrv = root.right.val;
            graph.get(rrv).add(rv);
            graph.get(rv).add(rrv);
        }
        dfs(root.left);
        dfs(root.right);
    }
}