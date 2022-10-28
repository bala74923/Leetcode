package Graph;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class _994_Rotting_Oranges {
    static int solve(int[][] arr){
        Queue<int[]> q = new LinkedList<>();
        //0-> nothing, 1->fresh, 2->rotten
        int levels=0 , row = arr.length, col  =arr[0].length;
        int fresh= 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(arr[i][j]==2)  q.add(new int[]{i,j});
                if(arr[i][j]==1) fresh++;
            }
        }
        int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
        if(fresh==0) return 0;
        while(!q.isEmpty()){
            levels++;
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] front = q.poll();
                for(int[] dir: dirs){
                    int x = front[0]+dir[0], y = front[1]+dir[1];
                    if(x>-1 && y>-1  && x<row&& y<col && arr[x][y]==1){
                        q.add(new int[]{x,y});
                        fresh--;
                        arr[x][y] =2;
                    }
                }
            }
            if(fresh==0) return levels;
        }
        return fresh>0?-1:levels;
    }
}
