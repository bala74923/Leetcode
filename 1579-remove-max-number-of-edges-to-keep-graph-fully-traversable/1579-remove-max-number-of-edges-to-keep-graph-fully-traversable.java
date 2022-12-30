class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        // kruskals is one of the best way 
        // make two separate dsuf for alice and bob and print count of 
        // unwanted edges
        Arrays.sort(edges , (a,b)->b[0]-a[0]);
        
        int[] alice = new int[n+1] , bob = new int[n+1];
        Arrays.fill(alice, - 1);
        Arrays.fill(bob , -1);
        int res = 0;
        for(int[] e: edges){
            int type = e[0], u = e[1], v = e[2];
            boolean val = true;
            if(type==3) {
                val = union(u,v,alice);
                boolean val2 = union(u,v,bob);
                val = val || val2;
            }
            else if(type==1) val = union(u,v,alice);
            else if(type==2) val = union(u,v,bob);
            if(!val) res++;
        }
        int c1 =0,c2 = 0;
        for(int i=1;i<=n;i++){
            if(alice[i]==-1) c1++;
            if(bob[i]==-1) c2++;
        }
        if(c1>1 || c2>1 ) return -1;
        return res;
    }
    boolean union(int a,int b,int[] dsuf){
        int pa = find(a, dsuf), pb = find(b , dsuf);
        if(pa == pb) return false;
        else{
            dsuf[pa] = pb;
            return true;
        }
    }
    int find(int node,int[] dsuf){
        if(dsuf[node]==-1)
            return  node;
        return dsuf[node] = find(dsuf[node] , dsuf);
    }
}