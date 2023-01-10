class Solution {
    int[][] dp;
    public boolean canPartition(int[] nums) {
        // can we able to form total/2
        int tot = 0;
        for(int n: nums){
            tot  = tot+n;
        }
        if(tot%2 == 1) return false;
        int need = tot/2, n = nums.length;
        dp = new int[n][need+1];
        for(int[] dp1: dp)
            Arrays.fill(dp1,-1);
        return f(n-1, need, nums);
    }
    boolean f(int ind,int sum,int[] nums){
        if(sum == 0) return true;
        if(ind ==0){
            return sum == 0|| nums[0] == sum;
        }
        if(dp[ind][sum]!=-1)
            return dp[ind][sum] ==1;
        boolean pick = false;
        if(sum>= nums[ind]){
            pick = f(ind-1, sum-nums[ind], nums);
        }
        boolean not_pick = f(ind-1, sum, nums);
        return (dp[ind][sum] = (pick || not_pick)?1:0)==1;
    }
}