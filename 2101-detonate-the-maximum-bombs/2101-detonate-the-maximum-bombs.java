class Solution {
    long distance(int x1,int y1,int x2,int y2){
        long p1=  x2-x1;
        p1 = p1*p1;
        long p2 = y2-y1;
        p2 = p2*p2;
        return p1+p2;
    }
    public int maximumDetonation(int[][] bombs) {
        int N = bombs.length;
        int res = 0;
        for(int i=0;i<N;i++){
            int curr = dfs(i, bombs, new boolean[N]);
            res = Math.max(res, curr);
        }
        return res;
    }
    int dfs(int curr,int[][] bombs,boolean[] visited){
        if(visited[curr]) return 0;
        visited[curr] = true;
        int affected = 0;
        for(int i=0;i<bombs.length;i++){
            if(willAffect(curr,i,bombs)){   
                affected += dfs(i,bombs,visited); 
            }   
        }
        return  1+ affected;
    }
    // here i is the bombing node
    boolean willAffect(int i,int j,int[][] bombs){
        long dist = distance(bombs[i][0],bombs[i][1], bombs[j][0], bombs[j][1]);
        long can = bombs[i][2];
        return dist<=can*can;// distance between two bombs is less than radius than it will be triggered
    }
}