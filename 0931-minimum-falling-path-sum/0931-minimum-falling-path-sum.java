class Solution {
    int[][] dp ;
    public int minFallingPathSum(int[][] matrix) {
        int res = int_max;
        int R = matrix.length, C = matrix[0].length;
        dp = new int[R][C];
        for(int[] dp1: dp)
            Arrays.fill(dp1,-1);
        for(int col=0;col<matrix[0].length;col++){
            res = Math.min(res,f(0,col,matrix));
        }
        return res;
    }
    int int_max = (int)1e9;
    int f(int row,int col,int[][] matrix){
        if(col>=matrix[0].length || col<0) return int_max;
        if(row==matrix.length-1) return matrix[row][col];
        if(dp[row][col]!=-1)
            return dp[row][col];
        int res = int_max;
        res = Math.min(res,f(row+1,col-1,matrix));
        res = Math.min(res,f(row+1,col,matrix));
        res = Math.min(res,f(row+1,col+1,matrix));
        return dp[row][col]= res+ matrix[row][col];
    }
}