package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class _542_01_Matrix {
    static int[][] dirs4 = {{-1,0},{0,-1},{0,1}, {1,0}};
    static int[][] solve(int[][] matrix) {

        int m = matrix.length, n = matrix[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        // add root to q
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0) {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        // set root as true in visited
        int level=0;
        while(!q.isEmpty()){
            ++level;
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] front = q.poll();
                for(int[] dir: dirs4){
                    int x =  dir[0]+front[0],y = dir[1]+front[1];
                    // checking only valid and already visited
                    if(x>-1 && y>-1&& x<m && y<n && !visited[x][y]
                    && matrix[x][y]==1){
                        // add it to queue
                        matrix[x][y] = level;
                        visited[x][y] = true;
                        q.add(new int[]{x,y});
                    }

                    // end of processing new cell
                }

                // one node (front) is done processing
            }
            // one level is done processing
        }
        // return answer
        return matrix;
    }
}
