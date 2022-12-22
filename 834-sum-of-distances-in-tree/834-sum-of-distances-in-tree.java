class Solution {
    int[] count,res;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        List<List<Integer>> list  = new ArrayList<>();
        for(int i=0;i<n;i++)
            list.add(new ArrayList());
        for(int[] e: edges){
            list.get(e[0]).add(e[1]);
            list.get(e[1]).add(e[0]);
        }
         count = new int[n];
         res = new int[n];
        dfs0(0,-1, list);
        solnDfs(0,-1, list);
        return res;
    }
    void solnDfs(int node, int par,List<List<Integer>> list){
        for(int child: list.get(node)){
            if(child==par) continue;
            res[child] = res[node] - count[child] + list.size() - count[child];
            solnDfs(child, node, list);
        }
    }
    // calculate sum of distances for node 0
    void dfs0(int node,int par,List<List<Integer>> list){
        for(int child: list.get(node)){
            if(child==par) continue;
            dfs0(child, node, list);
            count[node]+= count[child];
            // res[child]+ (1*count[child]) count[child] nodes having +1 distance from root
            res[node] += res[child] + count[child]; 
        }
        count[node]++;
    }
}