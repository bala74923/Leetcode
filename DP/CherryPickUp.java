package DP;

public class CherryPickUp {
    public static void main(String[] args) {

    }
    static int[][] arr;
    static int[][][][] memo;
    static int n;
    static  int Pickup(int[][] grid) {
        arr = grid;
        n = arr.length;
        memo = new int[n+1][n+1][n+1][n+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                for(int k=0;k<=n;k++){
                    for(int l=0;l<=n;l++){
                        memo[i][j][k][l] = -1;
                    }
                }
            }
        }
        int val =  f(0,0,0,0);
        return Math.max(val,0);
    }
    static int f(int i1,int j1,int i2,int j2){
        if(i1>=n||i2>=n||j1>=n||j2>=n||arr[i1][j1]==-1||arr[i2][j2]==-1){
            return Integer.MIN_VALUE;
        }

        if(i1==n-1 && j1==n-1){
           return arr[i1][j1];
        } if(i2==n-1 && j2==n-1){
            return arr[i2][j2];
        }
        if(memo[i1][j1][i2][j2]!=-1)
            return memo[i1][j1][i2][j2];

        int sum = arr[i1][j1];
        if(i1!=i2||j1!=j2)  sum+=arr[i2][j2];

        // j1 moves right
        int rt2 =  f(i1,j1+1,i2,j2+1);
        int bt2 =  f(i1,j1+1,i2+1,j2);
        int right = Math.max(rt2,bt2);
        //i1 goes down
        rt2 = f(i1+1,j1,i2,j2+1);
        bt2 = f(i1+1,j1,i2+1,j2);
        int bottom = Math.max(rt2,bt2);
        return memo[i1][j1][i2][j2] = sum+Math.max(right,bottom);
    }
}
