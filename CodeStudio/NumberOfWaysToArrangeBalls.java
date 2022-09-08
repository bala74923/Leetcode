public class NumberOfWaysToArrangeBalls {

    public static void main(String[] args) {
        System.out.println(totalWays(1,2,1));
    }
    static long[][][][] memo ;
    public static long totalWays(int a, int b, int c)
    {
        memo = new long[a+1][b+1][c+1][4];
        for(int i=0;i<=a;i++){
            for(int j=0;j<=b;j++){
                for(int k=0;k<=c;k++){
                    memo[i][j][k][0] = -1;
                    memo[i][j][k][1] = -1;
                    memo[i][j][k][2] = -1;
                    memo[i][j][k][3] = -1;
                }
            }
        }
        return f(a,b,c,3);
    }
    static long f(int a,int b,int c,int prev){
        if(a==0 && b==0 && c==0)
            return 1;
        if(a==-1||b==-1||c==-1) return 0;
        if(memo[a][b][c][prev]!=-1)
            return memo[a][b][c][prev];
        long count = 0;
        if(prev!=0)
            count+= f(a-1,b,c,0);
        if(prev!=1)
            count+= f(a,b-1,c,1);
        if(prev!=2)
            count+= f(a,b,c-1,2);
        return  memo[a][b][c][prev] = count;
    }
}
