class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<n; i++){
            list.add( new ArrayList<>());
        }
        for(int[] e: edges){
            list.get(e[0]).add(e[1]);
            list.get(e[1]).add(e[0]);
        }
        int[] res = new int[n];
        dfs(0,-1, list,res, labels);
        return res;
    }
    int[] dfs(int curr,int par, List<List<Integer>> list, int[] res, String labels){
        int[] curr_cols = new int[26];
        for(int adj: list.get(curr)){
            if(adj!= par){
                // visit all childs
                int[] got_cols = dfs(adj, curr, list, res, labels);
                for(int i=0;i<26;i++)
                    curr_cols[i]+= got_cols[i];
            }
        }
        int index = labels.charAt(curr)-'a';
        // visit current
        res[curr] = ++curr_cols[index];
        return curr_cols;
    }
}