class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        res = new ArrayList<>();
        dfs(0,graph.length-1, new LinkedList<>(), graph);
        return res;
    }
    void dfs(int curr,int dest, LinkedList<Integer> path, int[][] graph){
        if(curr==dest){
            path.add(curr);
            res.add(new ArrayList<>(path));
            path.removeLast();
            return ;
        }
        path.add(curr);
        for(int adj: graph[curr]){
            dfs(adj,dest,path,graph);
        }
        path.removeLast();
    }
}