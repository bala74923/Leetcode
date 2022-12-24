//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    Stack<Integer> stack;
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        stack = new Stack<>();
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(i, visited , adj);
            }
        }
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0;i<V;i++)
            list.add( new ArrayList<>());
            
        for(int u = 0;u<V; u++){
            for(int v : adj.get(u)){
                list.get(v).add(u);
            }
        }
        // reuse the visited array
        visited= new boolean[V];
        int scc = 0;
        while(!stack.isEmpty()){
            int front = stack.pop();
            if(visited[front]) continue;
            scc++;
            dfs3( front, visited , list);
        }
        return scc;
    }
    void dfs(int node,boolean[] visited , ArrayList<ArrayList<Integer>> graph){
        if(visited[node])
            return; 
        visited[node] = true;
        for(int adj: graph.get(node)){
            dfs(adj , visited, graph);
        }
        stack.push(node);
    }
    void dfs3(int node,boolean[] visited , ArrayList<ArrayList<Integer>> graph){
        if(visited[node])
            return; 
        visited[node] = true;
        for(int adj: graph.get(node)){
            dfs(adj , visited, graph);
        }
    }
    
}
