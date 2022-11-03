class Solution {
    static int[][] dirs = {{-1,0},{0,-1},{0,1}, {1,0}};
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int row=0;row<m;row++){
            dfs(row,0,grid,visited);
            dfs(row,n-1,grid,visited);
        }
        for(int col=0;col<n;col++){
            dfs(0,col,grid,visited);
            dfs(m-1,col,grid,visited);
        }
        int res= 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && !visited[i][j])
                    res++;
            }
        }
        return res;
    }
    static void dfs(int i,int j,int[][] grid,boolean[][] visited){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length||
          visited[i][j]|| grid[i][j]==0)
            return ;
        visited[i][j] = true;
        for(int[] dir: dirs){
            int x = dir[0]+i, y = j+dir[1];
            dfs(x,y,grid,visited);
        }
    }
}