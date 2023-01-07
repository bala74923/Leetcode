class Solution {
    int[][][][] dp;
    public boolean isScramble(String s1, String s2) {
       int n  =s1.length();
        dp = new int[n][n][n][n];
        for(int[][][] dp1: dp){
            for(int[][] dp2: dp1){
                for(int[] dp3: dp2){
                    Arrays.fill(dp3,-1);
                }
            }
        }
            
        return f(0,n-1,0,n-1,s1,s2);
    }
    boolean f(int l1,int h1,int l2,int h2,String s1,String s2){
        if(l1 == h1) return s1.charAt(l1) ==s2.charAt(h2);
        if(dp[l1][h1][l2][h2]!=-1)
           return dp[l1][h1][l2][h2] ==1 ;
        for(int cut = 0;l1+cut<h1;cut++){
            boolean swap = f(l1,l1+cut,l2,l2+cut,s1,s2) && f(l1+cut+1,h1,l2+cut+1,h2,s1,s2);
            int len = h1-l1-cut;
            boolean no_swap = f(l1+cut+1,h1,l2,l2+len-1,s1,s2) && f(l1,l1+cut,l2+len,h2,s1,s2);
            boolean curr = swap || no_swap;
            if(curr) {
                dp[l1][h1][l2][h2] = 1;
                return true;
            }
        }
        dp[l1][h1][l2][h2] = 0;
        return false;
    }
    String s(String s,int i,int j){return s.substring(i,j+1);}
}