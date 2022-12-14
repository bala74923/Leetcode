class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n= matrix[0].length;
        int res = 0;
        for(int start_col = 0;start_col<n;start_col++){
            boolean[] bool = new boolean[m];
            for(int i=0;i<m;i++)
                bool[i] = true;
            for(int end_col = start_col;end_col<n;end_col++){
                // track the continous rows that has 1's
                int count = 0,max_count = 0;
                for(int row = 0;row<m;row++){
                    bool[row] = bool[row]&(matrix[row][end_col]=='1');
                    if(bool[row]) count++;
                    else count = 0;
                    max_count = Math.max(count, max_count);
                }
                res = Math.max(res, max_count* (end_col-start_col+1));
            }
        }
        return res;
    }
}