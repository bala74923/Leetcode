class Solution {
    int[][] mem;
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length(), n2 = text2.length();
        mem = new int[n1][n2];
        for(int[] me1: mem)
            Arrays.fill(me1,-1);
        return f(n1-1,n2-1,text1,text2);
    }
    int f(int i,int j,String s1,String s2){
        if(i==-1 ||j==-1) return 0;
        if(mem[i][j]!=-1)
            return mem[i][j];
        if(s1.charAt(i)==s2.charAt(j))
            return mem[i][j] =  1+ f(i-1,j-1,s1,s2);
        else 
            return  mem[i][j] = Math.max(f(i-1,j,s1,s2),f(i,j-1,s1,s2));
    }
}