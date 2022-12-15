//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
@SuppressWarnings("unchecked") class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> ans = obj.shortestPath(n, m, edges);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int int_max = (int)1e9;
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        // code here
        int src = 1;
        ArrayList<ArrayList<int[]>> graph = get(edges, m, n);
        
        int[] dp = new int[n+1];
        Arrays.fill(dp,int_max);
        dp[src] = 0;
        
        // {distance, node_no}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[0]!=b[0]) return a[0]-b[0];
            return a[1]-b[1];
        });
        pq.add(new int[]{0,src});
        
        int[] prev = new int[n+1];
        Arrays.fill(prev,-1);
        
        while(!pq.isEmpty()){
            int[] front = pq.poll();
            int dist = front[0], node = front[1];
            for(int[] adj: graph.get(node)){
                int currDist = dist+ adj[1],cnode = adj[0];
                //System.out.println(currDist+"node ="+node+" to ="+cnode);
                if(currDist<dp[cnode]){
                    dp[cnode] = currDist;
                    pq.add(new int[]{currDist,cnode});
                    
                    prev[cnode] = node;
                }
                
            }
        }
        List<Integer> res = new ArrayList<>();
        if(dp[n]>=int_max) {
            res.add(-1);
            return res; // empty res
        }
        int parent = n;
        while(parent!=-1){
            res.add(0,parent);
            parent = prev[parent];
        }
        return res;
    }
    static ArrayList<ArrayList<int[]>> get(int[][] edges,int m,int n){
        ArrayList<ArrayList<int[]>> list = new ArrayList<>();
        
        for(int i=0;i<=n;i++) // n+1 vertices
            list.add(new ArrayList<>()); 
        
        for(int[] e: edges){
            int from = e[0], to =  e[1], cost = e[2];
            list.get(from).add(new int[]{to,cost});
            list.get(to).add(new int[]{from, cost});
        }
        return list;
    }
}