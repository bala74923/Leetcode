class Solution {
    public boolean isBipartite(int[][] graph) {
        int N = graph.length;
        int[] color = new int[N];
        Arrays.fill(color,-1);// let 0,1 be colors
        for(int i=0;i<N;i++){
            if(color[i]==-1 ){
                color[i] = 0;
                if(dfs(graph,color,i)==false)
                    return false;
            }
        }
       return true;
    }
    boolean check(int[][] graph,int[] color,int root){
        Queue<Integer> q = new LinkedList<>();
        q.add(root);
        color[root]= 0;
        
        while(!q.isEmpty()){
            int front = q.poll();
            for(int adj: graph[front]){
                if(color[adj]==color[front]) return false;
                else if(color[adj]==-1){
                    color[adj] = 1^color[front];
                    q.add(adj);
                }
            }
        }
        return true;
    }
    boolean dfs(int[][] graph,int[] color,int curr){
        for(int adj: graph[curr]){
            if(color[adj]==color[curr]) return false;
            if(color[adj]==-1){
                color[adj] = 1^color[curr];
                if(dfs(graph,color,adj)==false)
                    return false;
            }
        }
        return true;
    }
}