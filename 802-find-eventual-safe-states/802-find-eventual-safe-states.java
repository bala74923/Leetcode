class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        boolean[] cycle = new boolean[V];
        boolean[] visited = new boolean[V];
        boolean[] path = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                // perform dfs and remove nodes involving in cycle
                dfs(i,graph,visited,path,cycle);
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<V;i++){
            if(!cycle[i]) res.add(i);
        }
        return res;
    }
    boolean dfs(int curr,int[][] graph,boolean[] visited,boolean[] path
                ,boolean[] cycle){
        
        if(path[curr]) return true; // already visited in same path
        path[curr] = true;
        for(int a: graph[curr]){
            if(!visited[a]){ // already visited 
                if(dfs(a,graph,visited,path,cycle)==true){
                    cycle[curr] = true;
                    return true;
                }
            }
        }
        path[curr] = false;
        visited[curr] = true;
        return false;
    }
}