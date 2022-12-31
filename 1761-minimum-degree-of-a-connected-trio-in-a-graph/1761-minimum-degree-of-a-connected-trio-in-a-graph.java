class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        int[][] mat = new int[n+1][n+1];
        int[] deg = new int[n+1];
        for(int[] e: edges){
            mat[e[0]][e[1]]++;
            mat[e[1]][e[0]]++;
            deg[e[0]]++;deg[e[1]]++;
        }
        int int_max = (int)1e9;
        int res = int_max;
        for(int k=0;k<=n;k++){
            for(int i=0;i<=n;i++){
                for(int j=0;j<=n;j++){
                    if(mat[i][j]==1 && mat[i][k]==1 && mat[k][j] ==1){ // if there is a edge
                        // can i-k-j has a path
                        res = Math.min(res, deg[i]+deg[j]+deg[k]-6);
                    }
                }
            }
        }
        return res==int_max?-1: res;
    }
}