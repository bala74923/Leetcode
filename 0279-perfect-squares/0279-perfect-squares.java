class Solution {
    static int[][] memo;
    public int numSquares(int n) {
        List<Integer> list = new ArrayList<>();
        addPerfectSq(n,list);
        int len = list.size();
        memo = new int[len][n+1];
        
        for(int i=0;i<len;i++){
            for(int j=0;j<=n;j++){
                memo[i][j] = -1;
            }
        }
        
        return rec(len-1,n,list);
    }
    static int max = (int)1e9;
    // minimum number sum
    static int rec(int ind,int sum,List<Integer> list){
        if(ind==-1){
            return sum==0?0:max;
        }
        if(sum==0) return 0;
        if(memo[ind][sum]!=-1)
            return memo[ind][sum];
        
        int pick = max;
        if(sum>=list.get(ind)){
            pick = 1+ rec(ind,sum-list.get(ind),list);
        }
        int notPick = rec(ind-1,sum,list);
        return memo[ind][sum] = Math.min(pick,notPick);
    }
    static void addPerfectSq(int n,List<Integer> list){
        for(int i=1;i*i<=n;i++){
            list.add(i*i);
        }
    }
}