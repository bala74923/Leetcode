package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class _200_Number_of_Islands {
    static int solveBFS(char[][] grid){
        int islands = 0;
        int m = grid.length, n = grid[0].length;
        int[][] dirs = { {-1,0} , {0,1} , {1,0} , {0,-1} };
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){ // still not visited
                    Queue<int[]> q =  new LinkedList<>();
                    q.add(new int[]{i,j});
                    grid[i][j]='0'; // marks as visited
                    while(!q.isEmpty()){
                        int[] front=  q.poll();
                        for(int[] dir: dirs){
                            int x = front[0]+dir[0], y= front[1]+dir[1];
                            if(x>-1 && y>-1 && x<m && y<n
                            && grid[x][y]=='1'){
                                q.add(new int[]{x,y});
                                grid[x][y] = '0';
                            }
                        }
                    }

                    islands++;
                }
            }
        }
        return  islands;
    }
    static int solveDFS(char[][] grid){
        int islands = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1'){
                    dfs(i,j,grid);
                    islands++;
                }
            }
        }
        return islands;
    }
    static void dfs(int i,int j,char[][] grid){
        // visit islands
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]=='0')
            return ;
        grid[i][j] = '0';

        dfs(i-1,j,grid);
        dfs(i,j+1,grid);
        dfs(i+1,j,grid);
        dfs(i,j-1,grid);
    }
}
