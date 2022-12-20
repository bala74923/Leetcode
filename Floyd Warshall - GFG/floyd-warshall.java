//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrix[i][j]  =Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            obj.shortest_distance(matrix);
            for(int i = 0; i < n; i++){
                for(int j  = 0; j < n; j++){
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


//User function template for JAVA

class Solution
{
    public void shortest_distance(int[][] mat)
    {
        // Code here 
        int N = mat.length;
        int int_max = (int)1e9;
        replace(mat, -1, int_max);
        for(int k = 0;k<N; k++){
            for(int i=0; i<N;i++){
                for(int j=0;j<N;j++){
                    mat[i][j] = Math.min(mat[i][j], mat[i][k]+mat[k][j]);
                }
            }
        }
        replace(mat , int_max, -1);
    }
    public void replace(int[][] mat,int a,int b){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length; j++){
                if(mat[i][j] ==a )
                    mat[i][j] = b;
            }
        }
    }
}