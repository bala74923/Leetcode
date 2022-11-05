class Solution {
    int si=-1,sj=-1,ei=-1,ej=-1,zero;
    boolean[][] visited;
    public int uniquePathsIII(int[][] grid) {
        int m =grid.length,n= grid[0].length;
        zero = 0;
        visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    si = i;sj=j;
                }if(grid[i][j]==2){
                    ei = i;ej = j;
                }
                if(grid[i][j]==0)
                    zero++;
            }
        }
        return rec(si,sj,grid,0);
    }
    int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
    int rec(int i,int j,int[][] grid,int z){
        if(i==ei && j== ej) return z-1==zero?1:0;
        if(i<0 || j<0 || i>=grid.length|| j>=grid[0].length||
          visited[i][j] || grid[i][j]==-1)
            return 0;
        visited[i][j] = true;
        int res= 0;
        for(int[] dir: dirs){
            int x = i+dir[0],y =j+dir[1];
            res+= rec(x,y,grid,z+1);// curr must be zero
        }
        
        visited[i][j]  =false;
        return res;
    }
}