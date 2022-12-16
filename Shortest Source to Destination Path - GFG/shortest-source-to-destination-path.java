//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            String s1[] = read.readLine().split(" ");
            x = Integer.parseInt(s1[0]);
            y = Integer.parseInt(s1[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestDistance(N, M, a, x, y));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int int_max = (int)1e9;
    int shortestDistance(int N, int M, int A[][], int X, int Y) {
        // code here
        if(A[0][0]==0 || A[X][Y]==0)
            return -1;
        int[][] dp= new int[N][M];
        for(int i=0;i<N;i++){
            Arrays.fill(dp[i],int_max);
        }
        dp[0][0] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,0});
        int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
        while(!q.isEmpty()){
            int[] front = q.poll();
            for(int[] dir: dirs){
                int ci = front[1]+dir[0],cj = front[2]+dir[1];
                if(ci>=0 && cj>=0 && ci<N && cj<M && A[ci][cj]!=0){
                    //valid
                    if(dp[ci][cj]> 1+ front[0]){
                        dp[ci][cj]= front[0]+1;
                        q.add(new int[]{front[0]+1, ci,cj});
                    }
                }
            }
        }
        return dp[X][Y]>=int_max?-1:  dp[X][Y];
    }
};