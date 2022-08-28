package DP;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/climbing-stairs/
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(opti(45));
    }    
    static int opti(int n){
        int prev1=1,prev2=1,curr=1;
        for(int i=2;i<=n;i++){
            curr  = prev1+prev2;
            prev1 = prev2;
            prev2 = curr;
        }
        return prev2;
    }
    static int tab(int n){
        int[] dp = new int[n+1];
        dp[0]=1;
        if(n>=1)
            dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    static int f(int n){
        if(n<=1) return 1;
        if(memo[n]!=-1){
            return memo[n];
        }
        int one = f(n-1);
        int two = f(n-2);
        return memo[n] = one+two;
    }
    static int[] memo ;
    static int memoise(int n){
        memo = new int[n+1];
        Arrays.fill(memo,-1);
        return f(n);
    }
}
