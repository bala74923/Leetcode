class Solution {
    public int maxProfit(int[] prices) {
         int p_buy = 0, p_sell = 0, p_cool = 0;
        for(int ind = prices.length-1;ind>=0;ind--){
            int c_cool = p_buy;
            int c_sell = Math.max(prices[ind] +p_cool, p_sell);
            int c_buy = Math.max(-prices[ind]+ p_sell, p_buy);
            p_buy = c_buy;p_sell = c_sell;p_cool= c_cool;
        }
        return p_buy;
    }
}