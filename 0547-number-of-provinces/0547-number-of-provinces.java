class Solution {
    public int findCircleNum(int[][] grid) {
        int N = grid.length;
        int[] dsuf = new int[N];
        Arrays.fill(dsuf, -1);
        int res = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(grid[i][j] ==1){
                    union(i,j,dsuf);
                }
            }
        }
        for(int val: dsuf){
            if(val==-1) res++;
         }
        return res;
    }
    boolean union(int a,int b,int[] dsuf){
        int pa = find(a, dsuf), pb = find(b, dsuf);
        if(pa == pb) return false;
        else{
            dsuf[pa] = pb;
            return true;
        }
    }
    int find(int node,int[] dsuf){
        if(dsuf[node] == -1)
            return node;
        return dsuf[node]= find(dsuf[node], dsuf);
    }
}