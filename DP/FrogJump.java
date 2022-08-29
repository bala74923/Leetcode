package DP;

import java.util.Arrays;

/**
 * FrogJump (https://www.codingninjas.com/codestudio/problems/frog-jump_3621012)
 */
public class FrogJump {

    public static void main(String[] args) {
        
    }
    static int calcualateJump(int[] arr){
        int n = arr.length;
        return f(n-1,arr);
    }
    static int optimised(int n,int[] arr){
        int prev1=0,prev2=0;
        for(int ind=1;ind<n;ind++){
            int one = prev2+ Math.abs(arr[ind]-arr[ind-1]);
            int two = (int)1e9;
            if(ind>=2){
                two = prev1+Math.abs(arr[ind]-arr[ind-2]);
            }
            int curr = Math.min(one,two);
            prev1 = prev2;
            prev2 = curr;
        }
        return prev2;
    }
    

    static int tabulate(int n,int[] arr){
        int[] dp = new int[n];
        for(int ind=1;ind<n;ind++){
            int one = dp[ind-1]+ Math.abs(arr[ind]-arr[ind-1]);
            int two = (int)1e9;
            if(ind>=2){
                two = dp[ind-2]+Math.abs(arr[ind]-arr[ind-2]);
            }
            dp[ind] = Math.min(one,two);
        }
        return dp[n-1];
    }

    static int[] memo;
    static int memoise(int n,int[] arr){
        memo = new int[n];
        Arrays.fill(memo,-1);
        return f(n-1,arr);
    }
    static int f(int ind,int[] arr){
        if(ind==0){
            return 0;
        }
        if(memo[ind]!=-1){
            return memo[ind];
        }
        int one = f(ind-1,arr)+ Math.abs(arr[ind]-arr[ind-1]);
        int two = (int)1e9;
        if(ind>=2){
            two = f(ind-2,arr)+Math.abs(arr[ind]-arr[ind-2]);
        }
        return memo[ind] = Math.min(one,two);
    }
}