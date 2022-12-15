class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
       return solve(text1,text2);
    }
    int solve(String s1,String s2){
        int n1 = s1.length(), n2 = s2.length();
        int[] prev = new int[n2+1];
        for(int i=1;i<=n1;i++){
            int[] curr = new int[n2+1];
            for(int j=1;j<=n2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                     curr[j] =  1+ prev[j-1];
                else 
                    curr[j] = Math.max(prev[j],curr[j-1]);
            }
            prev = curr;
        }
        return prev[n2];
    }
}