class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory,(a,b)->a[0]-b[0]);
        List<Integer> list = new ArrayList<>();
        for(int[] curr: factory){
            for(int i=0;i<curr[1];i++) list.add(curr[0]);
        }
        long[][] dp = new long[robot.size()][list.size()];
        for(long[] d:dp)
            Arrays.fill(d,-1);
        return rec(0,0,robot,list,dp);
    }
    long rec(int i, int j,List<Integer> r,List<Integer> f,long[][] dp){
        if(i==r.size()) return 0;
        if(j==f.size()) return (long)1e17;
        if(dp[i][j]!=-1) return dp[i][j];
        long pick = Math.abs(r.get(i)-f.get(j))+ rec(i+1,j+1,r,f,dp);
        long notPick = rec(i,j+1,r,f,dp);
        return dp[i][j] = Math.min(pick,notPick);
    }
}