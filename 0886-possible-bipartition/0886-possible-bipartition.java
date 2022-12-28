class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> list = graph(dislikes,n);
        int[] color = new int[n+1];
        Arrays.fill(color, -1);
        for(int i=1;i<=n;i++){
            if(color[i]==-1){
                color[i] = 0;
                if(dfs(i,color,list)){ //return true if component is not bipartite
                    return false;
                }
            }
        }
        return true;
    }
    boolean dfs(int curr,int[] color,List<List<Integer>> list){
        int nc = color[curr]^1;
        for(int adj: list.get(curr)){
            if(color[adj]!=-1 && color[adj]!=nc)
                return true;// we cannot do it in bipartite
            else if(color[adj]==-1){
                color[adj] = nc;
                if(dfs(adj ,color, list))
                    return true;
            }
        }
        return false;
    }
    List<List<Integer>> graph(int[][] edges,int n){
        List<List<Integer>> list= new ArrayList<>();
        for(int i=0;i<=n;i++)
            list.add(new ArrayList<>());
        for(int[] e: edges){
            int from = e[0], to = e[1];
            list.get(from).add(to);
            list.get(to).add(from);
        }
        return list;
    }
}