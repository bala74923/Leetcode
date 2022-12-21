class Solution {
    public int minCostConnectPoints(int[][] points) {
        int sum  =0 , N = points.length;
        boolean[] visited = new boolean[N];
        // {wt, node, parent} -> parent for mst
        // {wt, node} -> sum
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0,0});
        
        
        while(!pq.isEmpty()){
            int[] front = pq.poll();
            int node = front[1], wt = front[0];
            if(visited[node]) continue;
            visited[node] = true;
            sum+= wt;
            for(int adj =0;adj< N;adj++){
                int newDist = Math.abs(points[node][0]-points[adj][0]) + Math.abs(points[node][1]-points[adj][1]);
                pq.add(new int[]{newDist,adj});
            }
        }
        return sum;
    }
}