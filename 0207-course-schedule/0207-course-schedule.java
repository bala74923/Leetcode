class Solution {
    public boolean canFinish(int N, int[][] edge) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<N;i++)
            list.add(new ArrayList<>());
        for(int[] e: edge){
            int from = e[0], to = e[1];
            list.get(to).add(from);
        }
        boolean[] visited = new boolean[N], path = new boolean[N];
        for(int i=0;i<N;i++){
            if(!visited[i] && dfs(i,list, visited,path)){
                return false; //cycle found cannot complete courses
            }
        }
        return true; // no cycle found
    }
    boolean dfs(int curr, List<List<Integer>> list,boolean[] visited, boolean[] path){
        if(path[curr]) return true; // cycle found
        path[curr] = true;
        for(int adj: list.get(curr)){
            if(!visited[adj] && dfs(adj , list, visited, path))
                return true;
        }
        path[curr] = false;
        visited[curr] = true;
        return false;
    }
    
}