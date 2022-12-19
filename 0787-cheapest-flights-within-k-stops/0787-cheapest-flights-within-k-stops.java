class Solution {
    int int_max=  (int)1e9;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> list = new ArrayList<>();
        for(int i=0;i<n;i++)
            list.add(new ArrayList<>());
        for(int[] e: flights){
            list.get(e[0]).add(new int[]{e[1],e[2]});
        }
        
        int[] dist = new int[n];
        Arrays.fill(dist,int_max);
        dist[src] = 0;
        
        //{step,distance,node}
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,src});
        
        while(!q.isEmpty()){
            int[] front= q.poll();
            int step = front[0], d =front[1], node = front[2];
            if(step>k) continue;
            for(int[] adj: list.get(node)){
                int nn =adj[0], nd = adj[1];
                if(nd+d< dist[nn]){
                    dist[nn] = nd+d;
                    if(nn!=dst)
                        q.add(new int[]{step+1,nd+d,nn});
                }
            }
        }
        
        return dist[dst]>=int_max?-1: dist[dst];
    }
}