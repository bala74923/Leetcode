class Solution {
    char[][] board;
    int m, n;
    int[][] dirs = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
    boolean[][] visited;
    // found x return true, out of bound return false
    public void solve(char[][] board) {
        this.board = board;
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for(int j=0;j<n;j++){
            dfs(0,j);
            dfs(m-1,j);
        }
        for(int i=0;i<m;i++){
            dfs(i,0);
            dfs(i,n-1);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]) board[i][j] = 'X';
            }
        }
    }
    void dfs(int i,int j){
        if(i<0|| j<0|| i>=m || j>=n || board[i][j]=='X' || visited[i][j]) return ;
        
        visited[i][j]= true;
        for(int[] dir: dirs){
            int x = dir[0]+i, y = j+dir[1];
            dfs(x,y);
        }
    }

    
}
