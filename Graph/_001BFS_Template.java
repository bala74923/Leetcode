package Graph;

import java.util.List;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class _001BFS_Template {
    static int[][] dirs8 = {{-1,-1},{-1,0},{-1,1}, {0,-1},{0,1}, {1,-1},{1,0},{1,1}};
    static int[][] dirs4 = {{-1,0},{0,-1},{0,1}, {1,0}};
    // bfs matrix
    static void bfs(int[][] matrix){

        int m = matrix.length, n = matrix[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        // add root to q
        // set root as true in visited
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] front = q.poll();
                for(int[] dir: dirs4){
                    int x =  dir[0]+front[0],y = dir[1]+front[1];
                    // checking only valid and already visited
                    if(x>-1 && y>-1&& x<m && y<n && !visited[x][y]){
                        // add it to queue
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
    }

    //bfs for integers
    static void bfs2(int[][] matrix,List<List<Integer>> graph){

        int m = matrix.length, n = matrix[0].length;
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        // add root to q
        // set root as true in visited
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int front = q.poll();
                for(int child: graph.get(front)){
                    if(!visited.contains(child)){
                        q.add(child);
                        visited.add(child);
                    }
                    // one child is done procesing
                }

                // one node (front) is done processing
            }
            // one level is done processing
        }
        // return answer
    }
}
