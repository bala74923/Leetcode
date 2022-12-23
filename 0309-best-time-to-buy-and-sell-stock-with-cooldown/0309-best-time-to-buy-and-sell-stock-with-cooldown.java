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
        int p_buy = 0, p_sell = 0, p_cool = 0;
        // ind-> 0 to N, prices -> 0 to 2
        for(int ind = N-1;ind>=0;ind--){
            // cool down
            int c_cool = p_buy;
               
            // sell or may not sell
            int sell = prices[ind] +p_cool;
            int not_sell = p_sell;
            int c_sell = Math.max(sell, not_sell);
               
            // buy or not buy
            int buy = -prices[ind]+ p_sell;
            int not_buy = p_buy;
            int c_buy = Math.max(buy, not_buy);
            
            p_buy = c_buy;
            p_sell = c_sell;
            p_cool= c_cool;
        }
        return p_buy;
    }
}