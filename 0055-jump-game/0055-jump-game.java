class Solution {
    public boolean canJump(int[] nums) {
        int N = nums.length;
         boolean[] dp = new boolean[N];
        dp[N-1] = true;
        for(int ind = N-2;ind>=0;ind--){
            for(int jump = 1;jump<=nums[ind] && ind+jump<N;jump++){
                if(dp[ind+jump]){
                    dp[ind] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
    
   
}