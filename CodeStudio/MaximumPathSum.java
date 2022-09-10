public class MaximumPathSum {
    public static void main(String[] args) {

    }
    public static int getMaxPathSum(int[][] matrix) {
       return memoise(matrix);
    }
    static int[][] memo;
    static int memoise(int[][] matrix){
        int m =matrix.length, n= matrix[0].length;
        memo = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                memo[i][j] = -1;
            }
        }

        int maxi = -(int)1e9;
        for(int j=0;j<matrix[0].length;j++)
            maxi  = Math.max(maxi,f(matrix,0,j));
        return maxi;
    }
    static int f(int[][] matrix,int i,int j){
        if(i==matrix.length-1)
            return matrix[i][j];

        if(memo[i][j]!=-1)
            return memo[i][j];

        //down
        int down = f(matrix,i+1,j);
        //downRight
        int downRight = Integer.MIN_VALUE;
        if(j+1<matrix[i].length)
            downRight = f(matrix,i+1,j+1);
        //downLeft
        int downLeft = Integer.MIN_VALUE;
        if(j>0) downLeft = f(matrix,i+1,j-1);
        return memo[i][j] = matrix[i][j]+Math.max(down,Math.max(downLeft,downRight));
    }

    static int tabulate(int[][] matrix){
        int m =matrix.length, n= matrix[0].length;
        int[][] dp = new int[m][n];

        for(int j=0;j<n;j++){
            dp[m-1][j] = matrix[m-1][j];
        }


        for(int i=m-2;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                //down
                int down = dp[i+1][j];
                //downRight
                int downRight = Integer.MIN_VALUE;
                if(j+1<matrix[i].length)
                    downRight = dp[i+1][j+1];
                //downLeft
                int downLeft = Integer.MIN_VALUE;
                if(j>0) downLeft = dp[i+1][j-1];
                dp[i][j] = matrix[i][j]+Math.max(down,Math.max(downLeft,downRight));
            }
        }
        int maxi = -(int)1e9;
        for(int j=0;j<matrix[0].length;j++)
            maxi  = Math.max(maxi,dp[0][j]);
        return maxi;
    }
    static int Spacetabulate(int[][] matrix){
        int m =matrix.length, n= matrix[0].length;
        int[] next = new int[n];

        for(int j=0;j<n;j++){
            next[j] = matrix[m-1][j];
        }
        for(int i=m-2;i>=0;i--){
            int[] curr = new int[n];
            for(int j=n-1;j>=0;j--){
                //down
                int down = next[j];
                //downRight
                int downRight = Integer.MIN_VALUE;
                if(j+1<matrix[i].length)
                    downRight = next[j+1];
                //downLeft
                int downLeft = Integer.MIN_VALUE;
                if(j>0) downLeft = next[j-1];
                curr[j] = matrix[i][j]+Math.max(down,Math.max(downLeft,downRight));
            }
            next = curr;
        }
        int maxi = -(int)1e9;
        for(int j=0;j<matrix[0].length;j++)
            maxi  = Math.max(maxi,next[j]);
        return maxi;
    }
}
