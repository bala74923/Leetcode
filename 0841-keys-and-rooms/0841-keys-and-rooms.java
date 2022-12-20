class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int N = rooms.size();
        boolean[] vis=  new boolean[N];
        dfs(0,rooms,vis);
        for(int i=0;i<N;i++){
            if(!vis[i])
                return false;
        }
        return true;
    }
    void dfs(int curr, List<List<Integer>> rooms,boolean[] v){
        if(v[curr]) return ;
        v[curr] = true;
        for(int adj: rooms.get(curr)){
            dfs(adj,rooms,v);
        }
    }
}