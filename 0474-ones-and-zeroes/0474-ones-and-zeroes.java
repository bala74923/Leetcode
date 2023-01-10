class Solution {
    int int_min = -(int)1e9;
    //ind=n-1 to -1, m= m to 0, n = n to 0
    int[][][] dp ;
    public int findMaxForm(String[] strs, int m, int n) {
        int N = strs.length;
        dp= new int[N][m+1][n+1];
        for(int[][] dp1: dp){
            for(int[] dp2: dp1)
                Arrays.fill(dp2, -1);
        }
        return f(N-1, m,n,strs);
    }
    int f(int ind, int m,int n,String[] strs){
        if(ind == -1){
            return 0;
        }
        if(dp[ind][m][n]!=-1)
            return dp[ind][m][n];
        int zeros  = 0,ones = 0;
        for(char c: strs[ind].toCharArray()){
            if(c=='0') zeros ++;
            else ones++;
        }
        int pick = int_min;
        if(zeros<=m && ones<= n){
            pick = 1+ f(ind-1, m-zeros, n-ones,strs);
        }
        int not_pick = f(ind-1,m,n,strs);
        return dp[ind][m][n] = Math.max(pick,not_pick);
    }
}