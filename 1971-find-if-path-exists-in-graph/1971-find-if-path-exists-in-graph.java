class Solution {
    public boolean validPath(int n, int[][] edges, int src, int dest) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++)
            list.add(new ArrayList<>());
        for(int[] e: edges){
            list.get(e[0]).add(e[1]);
            list.get(e[1]).add(e[0]);
        }
        return f(list,new boolean[n], src,dest);
    }
    boolean f(List<List<Integer>> graph,boolean[] visited, int curr, int dest){
        if(curr==dest) return true;
        if(visited[curr]) return false;
        visited[curr] = true;
        for(int adj: graph.get(curr)){
            if(f(graph, visited, adj, dest))
                return true;
        }
        return false;
    }
}