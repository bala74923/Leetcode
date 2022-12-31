class Solution {
   // Stack<String> st;
    int empty_squares = 0;
    int[][] dirs = {{-1,0},{0,-1},{0,1},{1,0}};
    public int uniquePathsIII(int[][] grid) {
        int si= -1,sj =- 1, di = -1,dj = -1;
        empty_squares  = 0;
       // st = new Stack<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    si = i;sj = j;
                }if(grid[i][j] == 2){
                    di = i;dj = j;
                }if(grid[i][j]!=-1) empty_squares++;
            }
        }
        int m = grid.length,n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        return dfs(si,sj, di,dj, grid, visited);
    }
    // hence m,n <=20 apply dfs
    int dfs(int ci,int cj,int di,int dj,int[][] grid,boolean[][] visited){
        if(ci<0 || cj<0 || ci>=grid.length || cj>=grid[0].length|| visited[ci][cj] || grid[ci][cj]==-1) return 0;
        if(ci==di && cj==dj  ){
           // System.out.println(st+" es="+empty_squares);
            return empty_squares==1?1:0;
        }
        empty_squares--; //using one square
        visited[ci][cj] = true;
        int res = 0;
        //st.push(ci+","+cj);
        for(int[] dir: dirs){
            int x= dir[0]+ci, y = dir[1]+cj;
            res+=dfs(x,y,di,dj, grid, visited);
        }
        visited[ci][cj] = false;
       // st.pop();
        empty_squares++;// removing one empty square
        return res;
    }
}