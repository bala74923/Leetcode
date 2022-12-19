class Solution {
    int mod = (int)1e9+7;
    public int countPaths(int n, int[][] roads) {
        List<List<long[]>> list = new ArrayList<>();
        for(int i=0;i<n;i++)
            list.add(new ArrayList<>());
        for(int[] e: roads){
            list.get(e[0]).add(new long[]{e[1],e[2]});
            list.get(e[1]).add(new long[]{e[0],e[2]});
        }
        long[] dist = new long[n];
        long[] count = new long[n];
       
        Arrays.fill(dist,Long.MAX_VALUE); dist[0] = 0 ;count[0]=1;
        
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->(int)(a[0]-b[0]));
        pq.add(new long[]{0,0});
        while(!pq.isEmpty()){
            long[] front = pq.poll();
            long d = front[0];
            int node = (int)front[1];
            for(long[] adj: list.get(node)){
                long nd = adj[1]+ d;
                int ncurr = (int)adj[0];
                if(nd<dist[ncurr]){
                    if(nd<dist[ncurr]) count[ncurr] = 0;
                    dist[ncurr] = nd;
                    if(ncurr!=n-1)
                        pq.add(new long[]{nd, ncurr});
                }
                if(nd == dist[ncurr]){
                    count[ncurr]= ((count[ncurr]%mod) + (count[node]%mod))%mod;
                }
            }
        }
        //System.out.println(dist[n-1]);
        return (int)count[n-1];
    }
}