class Solution {
    int int_max = (int)1e9;
    int[][] dirs=  {{-1,0},{0,1},{1,0},{0,-1}};
    public int minimumEffortPath(int[][] grid) {
        // not constant distance so dijkstra
        int M = grid.length, N = grid[0].length;
        int[][] dp = new int[M][N];
        for(int i=0;i<M;i++){
            Arrays.fill(dp[i],int_max);
        }
        dp[0][0] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0,0,0});
        
        while(!pq.isEmpty()){
            int[] front = pq.poll();
            int i = front[1],j = front[2];
            for(int[] dir: dirs){
                int x= front[1]+dir[0], y =front[2]+dir[1];
                if(x>=0 && y>=0 && x<M && y<N){
                    int dist  = Math.max( front[0],Math.abs(grid[i][j]-grid[x][y]));
                    if(dp[x][y]>dist){
                        dp[x][y] = dist;
                        pq.add(new int[]{dist,x,y});
                    }
                }
            }
        }
        return dp[M-1][N-1];
        
    }
}