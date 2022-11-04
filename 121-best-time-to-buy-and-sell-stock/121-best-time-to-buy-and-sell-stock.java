class Solution {
    public int maxProfit(int[] prices) {
        int max = 0,res = 0;
        for(int i=prices.length-1;i>=0;i--){
            res = Math.max(res,max-prices[i]);
            max = Math.max(max,prices[i]);
        }
        return res;
    }
}