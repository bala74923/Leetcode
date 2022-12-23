class Solution {
    public int findCircleNum(int[][] mat) {
        int n = mat.length;
        int[] dsuf = new int[n];
        Arrays.fill(dsuf,-1);
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==1){
                    union(i,j,dsuf);
                }
            }
        }
        int count  = 0;
        for(int i=0;i<n;i++){
            if(dsuf[i]==-1)
                count++;
        }
        return count;
    }
    boolean union(int u,int v,int[] dsuf){
        int pu = find(u,dsuf);
        int pv = find(v,dsuf);
        if(pu==pv){
            // both already in same component
            return false;
        }else{
            dsuf[pu] = pv;
            return true;
        }
    }
    int find(int u,int[] dsuf){
        if(dsuf[u]==-1){
            return u;
        }
        return dsuf[u] = find(dsuf[u],dsuf);
    }
}