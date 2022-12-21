class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<=n;i++)
            list.add(new ArrayList<>());
        for(int[] e: dislikes){
            int from = e[0], to = e[1];
            list.get(from).add(to);
            list.get(to).add(from);
        }
        int[] color = new int[n+1];
        Arrays.fill(color,-1);
        // check for all components
       for(int i=0;i<=n;i++){
           if(color[i]==-1){
               color[i] = 0;
               if(cycle(list, i, color))
                   return false;
           }
       }
        return true;
    }
    static boolean cycle(List<List<Integer>> list, int curr, int[] color){
        int newColor = color[curr]^1;
        for(int adj: list.get(curr)){
            if(color[adj]==color[curr])
                return true;
            else if(color[adj]==-1){
                color[adj] = newColor;
                if(cycle(list, adj, color))
                    return true;
            }
        }
        return false;
    }
}