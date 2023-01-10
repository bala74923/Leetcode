class Solution {
    public boolean canPartition(int[] nums) {
        // can we able to form total/2
        int tot = 0;
        for(int n: nums){
            tot  = tot+n;
        }
        if(tot%2 == 1) return false;
        int need = tot/2, n = nums.length;
      
        boolean[][] dp = new boolean[n][need+1];
        // base case
        dp[0][0] = true; 
        if(need >=nums[0]){
            dp[0][nums[0]] = true;
        }
        for(int ind = 1;ind<n; ind++){
            dp[ind][0] = true;
            for(int sum= 0; sum<=need; sum++){
                boolean pick = false;
                if(sum>= nums[ind]){
                    pick = dp[ind-1][ sum-nums[ind]];
                }
                boolean not_pick = dp[ind-1][sum];
                dp[ind][sum] = pick || not_pick;
            }
        }
        return dp[n-1][need];
        
    }
}