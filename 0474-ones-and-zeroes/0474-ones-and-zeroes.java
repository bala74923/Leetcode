class Solution {
    int int_min = -(int)1e9;
    //ind=n-1 to -1, m= m to 0, n = n to 0
    int[][][] dp ;
    public int findMaxForm(String[] strs, int m, int n) {
        int N = strs.length;
        int[] one = new int[N];
        for(int i=0;i<N;i++){
            for(char c: strs[i].toCharArray()){
                if(c=='1') one[i]++;
            }
        }
        
        int[][][] dp = new int[N+1][m+1][n+1];
        for(int ind = 1; ind<=N;ind++){
            for(int _m =0;_m<= m; _m++){
                for(int _n=0; _n<=n ; _n++){
                    
                    int ones =  one[ind-1], zeros  = strs[ind-1].length()-ones;           
                    int pick = int_min;
                    if(zeros<=_m && ones<= _n){
                        pick = 1+ dp[ind-1][_m-zeros][_n-ones];
                    }
                    int not_pick = dp[ind-1][_m][_n];
                    dp[ind][_m][_n] = Math.max(pick,not_pick);
                }
            }
        }
        return dp[N][m][n];
    }
    
}