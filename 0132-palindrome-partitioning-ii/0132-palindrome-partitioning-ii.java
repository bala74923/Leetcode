class Solution {
    int[] dp;
    public int minCut(String s) {
        int N = s.length();
        dp = new int[N];
        Arrays.fill(dp, -1);
        return f(0,s)-1; // it returns no of pieces
    }
    int f(int ind, String s){
        if(ind ==s.length()) return  0;
        if(dp[ind]!=-1)
            return dp[ind];
        int res = (int)1e9;
        for(int cut = ind;cut<s.length();cut++){
            if(ispal(s,ind,cut)){
                int curr = 1+ f(cut+1,s);
                res = Math.min(curr, res);
            }
        }
        return dp[ind] = res;
    }
    boolean ispal(String s,int lo,int hi){
        while(lo<hi){
            if(s.charAt(lo++)!=s.charAt(hi--))
                return false;
        }
        return true;
    }
}