package DC;

public class BuySellStockIV {
    public static void main(String[] args) {
        /*
            order:
            ======
            1) memoise and f
            2) tabulate
            3) SpaceOptimisedTabulate
            4) moreSpaceOptimisedTabulate
            5) CodeAndMoreSpaceOptimisedTabulate
         */
    }
    static int maxProfit(int k, int[] prices) {
        return CodeAndMoreSpaceOptimisedTabulate(prices,k);
    }
    static int tabulate(int[] prices,int k){
        int n = prices.length;
        int[][] dp =  new int[n+1][2*k+1];
        for(int index=n-1;index>=0;index--){
            for(int tno=2*k-1;tno>=0;tno--){
                if((tno&1)==0){//even ->buy
                    int buy = -prices[index]+dp[index+1][tno+1];
                    int notBuy = 0 + dp[index+1][tno];
                    dp[index][tno] =Math.max(buy,notBuy);
                }else{ //odd->sell
                    int sell = prices[index]+ dp[index+1][tno+1];
                    int notSell = dp[index+1][tno];
                    dp[index][tno] = Math.max(sell,notSell);
                }
            }
        }
        return dp[0][0];
    }

    static int SpaceOptimisedTabulate(int[] prices,int k){
        int n = prices.length;
        int[] next =  new int[2*k+1];
        for(int index=n-1;index>=0;index--){
            int[] curr = new int[2*k+1];
            for(int tno=2*k-1;tno>=0;tno--){
                if((tno&1)==0){//even ->buy
                    int buy = -prices[index]+next[tno+1];
                    int notBuy = 0 + next[tno];
                    curr[tno] =Math.max(buy,notBuy);
                }else{ //odd->sell
                    int sell = prices[index]+ next[tno+1];
                    int notSell = next[tno];
                    curr[tno] = Math.max(sell,notSell);
                }
            }
            next = curr;
        }
        return next[0];
    }


    static int moreSpaceOptimisedTabulate(int[] prices,int k){
        int n = prices.length;
        int[] dp =  new int[2*k+1];
        for(int index=n-1;index>=0;index--){
            int next_val = 0;
            for(int tno=2*k-1;tno>=0;tno--){
                int curr_val = dp[tno];
                if((tno&1)==0){//even ->buy
                    int buy = -prices[index]+next_val;
                    int notBuy = 0 + dp[tno];
                    dp[tno] =Math.max(buy,notBuy);
                }else{ //odd->sell
                    int sell = prices[index]+ next_val;
                    int notSell = dp[tno];
                    dp[tno] = Math.max(sell,notSell);
                }
                next_val = curr_val;
            }
        }
        return dp[0];
    }
    static int CodeAndMoreSpaceOptimisedTabulate(int[] prices,int k){
        int n = prices.length;
        int[] dp =  new int[2*k+1];
        for(int index=n-1;index>=0;index--){
            int next_val = 0;
            for(int tno=2*k-1;tno>=0;tno--){
                int curr_val = dp[tno];
                if((tno&1)==0)
                    dp[tno] =Math.max(dp[tno],-prices[index]+next_val);
                else
                    dp[tno] = Math.max(prices[index]+ next_val,dp[tno]);
                next_val = curr_val;
            }
        }
        return dp[0];
    }

    static int f(int index,int tno,int[] prices,int k){
        if(index==prices.length)
            return 0;
        if(k*2==tno)
            return 0;
        if(memo[index][tno]!=-1)
            return memo[index][tno];

        // lets take if tno -> even buy , odd sell
        if((tno&1)==0){//even ->buy
            int buy = -prices[index]+f(index+1,tno+1,prices,k);
            int notBuy = 0 + f(index+1,tno,prices,k);
            return memo[index][tno] =Math.max(buy,notBuy);
        }else{ //odd->sell
            int sell = prices[index]+ f(index+1,tno+1,prices,k);
            int notSell = f(index+1,tno,prices,k);
            return memo[index][tno] = Math.max(sell,notSell);
        }
    }
    static int[][] memo;
    static int memoise(int[] prices,int k){
        memo = new int[prices.length][2*k+1];
        for(int i=0;i<prices.length;i++){
            for(int j=0;j<=2*k;j++){
                memo[i][j] = -1;
            }
        }
        return f(0,0,prices,k);
    }
}
