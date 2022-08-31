package DC;

import java.util.ArrayList;
import java.util.List;

public class PacificAltanticWaterFlow {
    public static void main(String[] args) {
        int[][] arr = {{1,2,2,3,5},
        {3,2,3,4,4},{2,4,5,3,1},
        {6,7,1,4,5},{5,1,1,2,4}};
        System.out.println(pacificAtlantic(arr)); // DFS 915 ms
    }   
    static List<List<Integer>> pacificAtlantic(int[][] arr) {
        int m = arr.length,n= arr[0].length;
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(check(arr,i,j,m,n)){
                    List<Integer> l = new ArrayList<>();l.add(i);l.add(j);
                    list.add(l);
                }
            }
        }
        return list;
    } 
    static boolean check(int[][] arr,int i,int j,int m,int n){
        return dfsOnAtlantic(arr, i, j, new boolean[m][n], arr[i][j]+1) && 
        dfsOnPacific(arr, i, j,new boolean[m][n],arr[i][j]+1);
    }
    static boolean  dfsOnAtlantic(int[][] arr,int i,int j,boolean[][] visited,int prev){
        if(i>=arr.length || j>=arr[0].length) return true;
        if(i<0 || j<0) return false;
        if(visited[i][j] || prev<arr[i][j]) return false;
        visited[i][j] = true;
        boolean value = false;
        value = value||dfsOnAtlantic(arr,i,j+1,visited,arr[i][j]);
        value = value|| dfsOnAtlantic(arr,i+1,j,visited,arr[i][j]);
        value = value||dfsOnAtlantic(arr,i-1,j,visited,arr[i][j]);
        value = value|| dfsOnAtlantic(arr,i,j-1,visited,arr[i][j]);
        return value;
    }
    static boolean  dfsOnPacific(int[][] arr,int i,int j,boolean[][] visited,int prev){
        if(i<0 || j<0) return true;
        if(i>=arr.length || j>=arr[0].length) return false;
        if(visited[i][j]|| prev<arr[i][j]) return false;
        visited[i][j] = true;
        boolean value = false;
        value = value||dfsOnPacific(arr,i,j+1,visited,arr[i][j]);
        value = value|| dfsOnPacific(arr,i+1,j,visited,arr[i][j]);
        value = value||dfsOnPacific(arr,i-1,j,visited,arr[i][j]);
        value = value|| dfsOnPacific(arr,i,j-1,visited,arr[i][j]);
        return value;
    }
}
