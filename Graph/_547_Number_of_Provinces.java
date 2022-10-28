package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class _547_Number_of_Provinces {
    static int solveBFS(int[][] isConnected){
        int provinces = 0;
        int N = isConnected.length;
        boolean[] visited = new boolean[N];
        for(int vertex = 0;vertex< N; vertex++){
            if(!visited[vertex]){
                visited[vertex] = true;
                Queue<Integer> q = new LinkedList<>();
                q.add(vertex);
                while(!q.isEmpty()){
                    int front = q.poll();
                    for(int neighbour=0;neighbour<N;neighbour++){
                        if(isConnected[front][neighbour]==1 &&
                        !visited[neighbour]){
                            q.add(neighbour);
                            visited[neighbour] = true;
                        }
                    }
                }
                provinces++;
            }
        }
        return  provinces;
    }
    static int solveDFS(int[][] isConnected){
        int provinces = 0;
        int N = isConnected.length;
        boolean[] visited = new boolean[N];
        for(int vertex = 0;vertex< N; vertex++){
            if(!visited[vertex]){
                dfs(isConnected,visited,vertex);
                provinces++;
            }
        }
        return  provinces;
    }
    static void dfs(int[][] isConnected,boolean[] visited,int curr){
        visited[curr] = true;
        for(int i=0;i<isConnected.length;i++){
            if(isConnected[curr][i]==1 && !visited[i]){
                dfs(isConnected,visited,i);
            }
        }
    }
}
