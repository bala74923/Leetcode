class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
       return solve(text1,text2);
    }
    int solve(String s1,String s2){
        int n1 = s1.length(), n2 = s2.length();
        int[] dp = new int[n2+1];
        for(int i=1;i<=n1;i++){
            int prev_state = 0;
            for(int j=1;j<=n2;j++){
                int curr_state = dp[j];
                if(s1.charAt(i-1)==s2.charAt(j-1))
                     dp[j] =  1+ prev_state;
                else 
                    dp[j] = Math.max(dp[j],dp[j-1]);
                prev_state = curr_state;
            }
        }
        return dp[n2];
    }
}