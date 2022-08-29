package DC;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
            };
        System.out.println(getIslandsCount(grid)); // BFS 10ms
    }
    static int getIslandsCount(char[][] grid){
        int m = grid.length,n = grid[0].length;
        int totalCount=0;

        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        
        //adding all 1's
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    q.add(new int[]{i,j});
                }
            }
        }

        int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};

        while(!q.isEmpty()){ //checking all the 1's is it forming island

            int[] island =q.poll();

            if(!visited[island[0]][island[1]]){

                visited[island[0]][island[1]] = true;

                Queue<int[]> neighbors = new LinkedList<>();
                neighbors.add(new int[]{island[0],island[1]});

                while(!neighbors.isEmpty()){
                    int[] front = neighbors.poll();
                    for(int[] dir:dirs){
                        int x = front[0]+dir[0], y = front[1]+dir[1];

                        if(x>-1 && x<m && y>-1 && y<n && grid[x][y]=='1' &&!visited[x][y]){
                            neighbors.add(new int[]{x,y});
                            visited[x][y] = true;
                        }
                    }
                }
                totalCount++;
            }

        }

        return totalCount;
    }    
}
