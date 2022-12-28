class Solution {
    public boolean isBipartite(int[][] graph) {
        // graph can be disconnected
        int N  = graph.length;
        int[] color = new int[N];
        Arrays.fill(color, -1); // unfilled
        for(int i=0;i<N;i++){
            if(color[i]==-1){ // another component
                // check for bipartite
                color[i] = 0;
                if(dfs(i, color , graph))
                    return false;
            }
        }
        return true;
    }
    boolean dfs(int node,int[] color, int[][] graph){
        int curr_col = color[node];
        int new_col = color[node]^1;
        for(int adj: graph[node]){
            if(color[adj]!=-1 && color[adj]!=new_col){
                return true;
            }else if(color[adj]==-1){
                color[adj] = new_col;
                if(dfs(adj,color,graph))
                    return true;
            }
        }
        return false;
    }
}