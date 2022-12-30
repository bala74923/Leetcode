class Solution {
    int int_max = (int)1e9;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> list = graph(n, flights);
        int[] dp = new int[n];
        Arrays.fill(dp , int_max);
        dp[src] = 0;
        // here stops increase unit wise so use queue
        //{stops , cost, node}
        PriorityQueue<int[]> pq = 
            new PriorityQueue<>(
            (a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        pq.add(new int[]{0,0,src});
        
        while(!pq.isEmpty()){
            int[] front = pq.poll();
            int node = front[2], stp = front[0], cost = front[1];
            for(int[] adj: list.get(node)){
                int adj_node = adj[0], ncost = cost+ adj[1];
                if(dp[adj_node] > ncost){
                    dp[adj_node] = ncost;
                    // if adj_node is not target but <k stops go ahead
                    if(stp+1<=k && adj_node!=dst){
                        pq.add( new int[]{stp+1, ncost, adj_node});
                    }
                }
            }
        }
        
        
        return dp[dst]==int_max ? -1: dp[dst];
    }
    List<List<int[]>> graph(int n,int[][] edges){
        List<List<int[]>> list = new ArrayList<>();
        for(int i=0;i<n;i++)
            list.add(new ArrayList<>());
        for(int[] e: edges){
            int from = e[0], to = e[1], cost = e[2];
            list.get(from).add( new int[]{to,cost});
        }
        return list;
    }
}