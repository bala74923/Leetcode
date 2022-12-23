class Solution {
    // 0- can buy, 1-  sell ,2 -cool down
    int[][] mem;
    public int maxProfit(int[] prices) {
        return solve(prices.length, prices);
        
    }
    int solve(int N,int[] prices){
        int[][] dp= new int[N+1][3];
        // ind-> 0 to N, tag-> 0 to 2
        //write base case
        dp[N][0]= dp[N][1] = dp[N][2] = 0;
        // ind-> 0 to N, prices -> 0 to 2
        for(int ind = N-1;ind>=0;ind--){
            // cool down
            dp[ind][2] = dp[ind+1][0];
               
            // sell or may not sell
            int sell = prices[ind] +dp[ind+1][2];
            int not_sell = dp[ind+1][1];
            dp[ind][1] = Math.max(sell, not_sell);
               
            // buy or not buy
            int buy = -prices[ind]+ dp[ind+1][1];
            int not_buy = dp[ind+1][0];
            dp[ind][0] = Math.max(buy, not_buy);
        }
        return dp[0][0];
    }
}