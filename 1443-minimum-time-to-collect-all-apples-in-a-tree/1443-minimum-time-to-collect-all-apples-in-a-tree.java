class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++)
            list.add( new ArrayList<>());
        for(int[] e: edges) {
            list.get(e[0]).add(e[1]);
            list.get(e[1]).add(e[0]);
        }
        return Math.max(0 ,dfs(0,-1, list, hasApple)-1)<<1;
    }
    int dfs(int curr,int par, List<List<Integer>> tree, List<Boolean> has){
        int max = 0;
        for(int adj: tree.get(curr)){
            if(adj!=par)
            max =max+ dfs(adj, curr ,tree, has);
        }
        // when we will add 1;
        if(max>0 || has.get(curr)) {
            //System.out.println(curr+" max = "+max);
            max = max+1;
        }
        return max;
    }
}