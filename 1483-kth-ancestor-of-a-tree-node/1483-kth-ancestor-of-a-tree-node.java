class TreeAncestor {
    // total possible rows can be or <= log(n)+1 as we are taking 
    // each index as power of 2, i means 2pow i
    // 2pow x = n
    // x = log(n) base 2
    int[][] up;
    int loglen;
    public TreeAncestor(int n, int[] parent) {
         loglen = (int)Math.ceil(Math.log(n)/Math.log(2))+2;
        up = new int[loglen][n];
        // here up[i][j] is (2power i) th ancestor of node j
        
        // parent is already given
        for(int i=0;i<n;i++){
            up[0][i] = parent[i];
        }
        
        for(int i=1;i<loglen;i++){
            for(int node=0;node<n;node++){
                int midParent = up[i-1][node];
                if(midParent==-1) midParent = 0; // as root
                up[i][node] = up[i-1][midParent];
            }
        }
         //process done
    }
    
    public int getKthAncestor(int node, int k) {
            for(int i=loglen-1;i>=0;i--){
                if((1<<i)<=k){
                    node = up[i][node];
                    k-=(1<<i);
                    if(k==0 || node ==-1) return node;
                }
            }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */