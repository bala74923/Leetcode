class Solution {
    // 0- can buy, 1-  sell ,2 -cool down
    int[][] mem;
    public int maxProfit(int[] prices) {
        int N = prices.length;
        mem = new int[N][3];
        for(int i=0;i<N;i++)
            Arrays.fill(mem[i],-1);
        return f(0,0, prices);
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