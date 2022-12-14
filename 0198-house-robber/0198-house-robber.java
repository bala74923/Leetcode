class Solution {
    int[] mem;
    public int rob(int[] nums) {
        // int N = nums.length;
        // mem = new int[N];
        // Arrays.fill(mem,-1);
        return solve(nums);
    }
    int solve(int[] nums){
         int N = nums.length;
        int[] dp = new int[N];
        dp[0] = nums[0];
        if(N>1) dp[1] = Math.max(nums[0],nums[1]);
        for(int ind=2;ind<N;ind++){
            int pick  = nums[ind]  + dp[ind-2];
            int notPick = dp[ind-1];
            dp[ind] = Math.max(pick,notPick);
        }
        return dp[N-1];
    }
    int f(int ind,int[] nums){
        if(ind==0) return nums[ind];
        if(ind==1) return Math.max(nums[0],nums[1]);
        if(mem[ind]!=-1)
            return mem[ind];
        int pick  = nums[ind]  + f(ind-2,nums);
        int notPick = f(ind-1,nums);
        return mem[ind] = Math.max(pick,notPick);
    }
}