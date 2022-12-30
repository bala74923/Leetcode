class Solution {
    int int_max = (int)1e9;
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dp = new int[n][n];
        
        //setting intial values
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) dp[i][j] = 0;
                else dp[i][j] = int_max; 
            }
        }
        for(int[] e: edges){
            dp[e[0]][e[1]]= e[2];
            dp[e[1]][e[0]] = e[2];
        }
        // now do floyd warshall
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k][j]);
                }
            }
        }
        int mini = int_max,  res = -1;
        for(int node =0;node<n;node++){
            int count = 0;
            for(int adj = 0;adj<n;adj++){
                if(dp[node][adj]<=distanceThreshold)
                    count++;
            }
            if(mini>=count){
                mini = count;
                res = node;
            }
        }
        return res;
    }
}