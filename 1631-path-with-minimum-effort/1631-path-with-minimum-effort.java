
class Solution {
    int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
    int int_min = -(int)1e9;
    int int_max = (int)1e9;
    public int minimumEffortPath(int[][] heights) {
        //applying dijkstra
        int M = heights.length, N = heights[0].length;
        int[][] dp= new int[M][N];
        // setting all values as int_max
        for(int[] dp1: dp)
            Arrays.fill(dp1,int_max);
        // setting src distance as 0
        dp[0][0] = 0;
        //{i,j,max_abs_diff}
        PriorityQueue<int[]> pq = 
            new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.add(new int[]{0,0,int_min});
        
        while(!pq.isEmpty()){
            int[] front = pq.poll();
            int i = front[0],j = front[1], upto=  front[2];
            for(int[] dir: dirs){
                int x = dir[0]+i,y = dir[1]+j;
                if(x>-1 && y>-1 && x<M && y<N){ // validity check
                    //System.out.println(x+" "+y+);
                    int new_diff=  Math.max( Math.abs(heights[i][j]-heights[x][y]),upto);
                    if(new_diff< dp[x][y]){
                        dp[x][y] = new_diff;
                        pq.add(new int[]{ x, y, new_diff});
                    }
                }
            }
        }
        
        return dp[M-1][N-1];
    }
}