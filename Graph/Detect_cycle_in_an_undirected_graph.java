package Graph;

import java.util.*;

public class Detect_cycle_in_an_undirected_graph {
    class BFS{
        public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
            // Code here
            boolean[] visited= new boolean[V];
            boolean res=  false;
            for(int src=0;src<V;src++){
                if(!visited[src]){
                    res = res|| solvBFS(src,adj,visited);
                }
            }
            return res;
        }
        public boolean solvBFS(int V, ArrayList<ArrayList<Integer>> adj,boolean[] visited) {
            // Code here
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{V,-1});
            visited[V] = true;

            while(!q.isEmpty()){
                int[] front=  q.poll();
                //front[0] = current, front[1] =parent
                for(int child: adj.get(front[0])){
                    if(child!=front[1]){
                        if(!visited[child]){
                            visited[child] = true;
                            q.add(new int[]{child,front[0]});
                        }else return true;
                    }
                }
            }
            return false;
        }
    }
    class DFSSolution{
        public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
            // Code here
            boolean[] visited= new boolean[V];
            boolean res=  false;
            for(int src=0;src<V;src++){
                if(!visited[src]){
                    res = res|| solvDFS(src,-1,adj,visited);
                }
            }
            return res;
        }
        public boolean solvDFS(int V,int parent, ArrayList<ArrayList<Integer>> adj,boolean[] visited) {
            // Code here
            visited[V] = true;
            for(int child: adj.get(V)){
                if(child!=parent){
                    if(!visited[child]){
                        if(solvDFS(child,V,adj,visited))
                            return true;
                    }else return true;
                }
            }
            return false;
        }
    }

}
