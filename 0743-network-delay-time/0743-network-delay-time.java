class Solution {
    int int_max = (int)1e9;
    public int networkDelayTime(int[][] edges, int n, int k) {
        List<List<int[]>> list = toGraph(n, edges);
        int[] dp  = new int[n+1];
        Arrays.fill(dp, int_max);
        // perform dijkstra
        // dist, node
        int src = k;
        dp[k] = 0;
        PriorityQueue<int[]> pq = 
            new PriorityQueue<>((a,b)->a[0]-b[0]);
        
        pq.add( new int[]{0, src});
        while(!pq.isEmpty()){
            int[] front = pq.poll();
            int node = front[1], dist= front[0];
            for(int[] adj: list.get(node)){
                int ndist = dist+adj[1], adj_node = adj[0];
                if(ndist<dp[adj_node]){
                    dp[adj_node]= ndist;
                    pq.add( new int[]{ ndist, adj_node});
                }
            }
        }
        
        //System.out.println(Arrays.toString(dp));
        int res= -1;
        for(int i=1;i<=n;i++)
            res = Math.max( res, dp[i]);
        return res==int_max?-1: res;
    }
    List<List<int[]>> toGraph(int n,int[][] edges){
        List<List<int[]>> list = new ArrayList<>();
        for(int i=0;i<=n;i++)
            list.add(new ArrayList<>());
        for(int[] e: edges){
            list.get(e[0]).add( new int[]{e[1],e[2]});
           // list.get(e[1]).add( new int[]{e[0],e[2]});
        }
        return list;
    }
}