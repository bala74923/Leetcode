class Solution {
    int empty_squares = 0;
    int[][] dirs = {{-1,0},{0,-1},{0,1},{1,0}};
    public int uniquePathsIII(int[][] grid) {
        int si= -1,sj =- 1, di = -1,dj = -1;
        empty_squares  = 0;
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
        int[] visited = new int[m];
        //boolean[][] visited = new boolean[m][n];
        return dfs(si,sj, di,dj, grid, visited);
    }
    // hence m,n <=20 apply dfs
    int dfs(int ci,int cj,int di,int dj,int[][] grid,int[] bit){
        if(ci<0 || cj<0 || ci>=grid.length || cj>=grid[0].length||
           isVisited(bit[ci],cj) || grid[ci][cj]==-1) 
            return 0;
        
        if(ci==di && cj==dj  ) return empty_squares==1?1:0;
        
        empty_squares--; //using one square
        //visited[ci][cj] = true;
        bit[ci] = visit(bit[ci],cj);
        int res = 0;
        
        for(int[] dir: dirs){
            int x= dir[0]+ci, y = dir[1]+cj;
            res+=dfs(x,y,di,dj, grid, bit);
        }
        
        //visited[ci][cj] = false;
         bit[ci] = unvisit(bit[ci],cj);
        
        empty_squares++;// removing one empty square
        return res;
    }
    boolean isVisited(int hash,int n){
        return (hash&(1<<n))!=0;
    }
    int visit(int hash,int n){
        return (hash|(1<<n));
    }
    int unvisit(int hash,int n){
        return (hash^(1<<n));
    }
}