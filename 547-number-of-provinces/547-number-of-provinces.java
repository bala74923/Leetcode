class Solution {
    public int findCircleNum(int[][] mat) {
        int n = mat.length;
        int[] dsuf = new int[n];
        int[] size = new int[n];
        Arrays.fill(dsuf,-1);
        Arrays.fill(size,1);
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==1){
                    union(i,j,dsuf,size);
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
    boolean union(int u,int v,int[] dsuf,int[] size){
        int pu = find(u,dsuf);
        int pv = find(v,dsuf);
        if(pu==pv){
            // both already in same component
            return false;
        }else{
            if(size[pu]<size[pv]){
                dsuf[pu] = pv;
                size[pv] += size[pu];
            }else{
                dsuf[pv] = pu;
                size[pu] += size[pv];
            }
            //dsuf[pu] = pv;
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