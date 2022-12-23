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
            for(int tag = 2;tag>=0;tag--){
                if(tag==2){ // cool down
                    dp[ind][tag] = dp[ind+1][0];
                }else if( tag==1){ // sell or may not sell
                    int sell = prices[ind] +dp[ind+1][2];
                    int not_sell = dp[ind+1][1];
                    dp[ind][tag] = Math.max(sell, not_sell);
                }else{
                    // buy or not buy
                    int buy = -prices[ind]+ dp[ind+1][1];
                    int not_buy = dp[ind+1][0];
                    dp[ind][tag] = Math.max(buy, not_buy);
                }
            }
        }
        return dp[0][0];
    }
    int f(int ind,int tag, int[] prices){
        if(prices.length ==  ind)
            return 0;
        if(mem[ind][tag]!=-1)
            return mem[ind][tag];
        if(tag==2){ // cool down
            return mem[ind][tag] = f(ind+1, 0, prices);
        }else if( tag==1){ // sell or may not sell
            int sell = prices[ind] +f(ind+1, 2, prices);
            int not_sell = f(ind+1, 1, prices);
            return mem[ind][tag] = Math.max(sell, not_sell);
        }else{
            // buy or not buy
            int buy = -prices[ind]+ f(ind+1, 1, prices);
            int not_buy = f(ind+1, 0, prices);
            return mem[ind][tag] = Math.max(buy, not_buy);
        }
    }
}