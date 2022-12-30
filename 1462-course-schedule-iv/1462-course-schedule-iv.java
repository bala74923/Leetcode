class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int n = numCourses;
        boolean[][] dp = new boolean[n][n];
        // {i->j} then dp[i][j] = true;
        for(int[] e: prerequisites){
            dp[e[0]][e[1]] = true;
        }
        for(int k = 0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    dp[i][j] = dp[i][j] || (dp[i][k] && dp[k][j]);
                }
            }
        }
        List<Boolean> res = new ArrayList<>();
        for(int[] e: queries){
            res.add(dp[e[0]][e[1]]);
        }
        return res;
    }
}