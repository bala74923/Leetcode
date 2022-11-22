class Solution {
    static int[][] memo;
    public int numSquares(int n) {
        List<Integer> list = new ArrayList<>();
        addPerfectSq(n,list);
        int len = list.size();
        memo = new int[len][n+1];
        
        for(int i=0;i<len;i++){
            for(int j=0;j<=n;j++){
                memo[i][j] = -1;
            }
        }
        
        int[][] dp = new int[len+1][n+1];
        
        // dp[ind][sum]
        for(int sum=1;sum<=n;sum++)
            dp[0][sum] = max;
        for(int ind=1;ind<=len;ind++){
            for(int sum=1;sum<=n;sum++){
                int pick = max;
                if(sum>=list.get(ind-1)){
                    pick = 1+ dp[ind][sum-list.get(ind-1)];
                }
                int notPick = dp[ind-1][sum];
                dp[ind][sum] = Math.min(pick,notPick);
            }
        }
        //return rec(len-1,n,list);
        return dp[len][n];
    }
    static int max = (int)1e9;
    // minimum number sum
    static int rec(int ind,int sum,List<Integer> list){
        if(ind==0){
            return sum==0?0:max;
        }
        if(sum==0) return 0;
        if(memo[ind][sum]!=-1)
            return memo[ind][sum];
        
        int pick = max;
        if(sum>=list.get(ind-1)){
            pick = 1+ rec(ind,sum-list.get(ind-1),list);
        }
        int notPick = rec(ind-1,sum,list);
        return memo[ind][sum] = Math.min(pick,notPick);
    }
    static void addPerfectSq(int n,List<Integer> list){
        for(int i=1;i*i<=n;i++){
            list.add(i*i);
        }
    }
}