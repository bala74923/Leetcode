class Solution {
    int[] dp;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp = new int[arr.length];
        Arrays.fill(dp,-1);
        return f(0,arr,k);
    }
    int f(int ind,int[] arr,int k){
        if(ind == arr.length) return 0;
        if(dp[ind]!=-1)
            return dp[ind];
        int res = 0,curr_max = 0;
        for(int cut = ind;cut<ind+k && cut<arr.length;cut++){
            curr_max = Math.max(arr[cut], curr_max);
            int curr = (curr_max*(cut-ind+1)) + f(cut+1,arr,k);
            res= Math.max(res,curr);
        }
        return dp[ind] = res;
    }
}