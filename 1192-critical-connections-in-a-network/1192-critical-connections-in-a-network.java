class Solution {
    int time = 0;
    List<List<Integer>> bridges;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> list = graph(n, connections);
        bridges = new ArrayList<>();
        int[] disc = new int[n], low = new int[n];
        Arrays.fill(disc,-1);
        time = 0;
        for(int i=0;i<n;i++){
            if(disc[i]==-1){
                dfs(i,-1,list,disc,low);
            }
        }
        return bridges;
    }
    void dfs(int curr,int parent,List<List<Integer>> graph,int[] disc,int[] low){
        // visit only the univisited nodes
        disc[curr] = low[curr] = ++time;
        for(int adj: graph.get(curr)){
            if(adj==parent) continue; // dont look at the same edge
            if(disc[adj]==-1){ // if not visited traverse and then update min values
                dfs(adj,curr,graph,disc,low);
                low[curr] = Math.min(low[curr],low[adj]);
            
            }else{ // already visited
                low[curr] = Math.min(low[curr],low[adj]);
            }
        }
        if(low[curr] == disc[curr] && parent!=-1)
            bridges.add(createBridge(parent,curr));
    }
    List<Integer> createBridge(int a,int b){
        List<Integer> list=  new ArrayList<>();
        list.add(a);list.add(b);
        return list;
    }
    List<List<Integer>> graph(int n,List<List<Integer>> edges){
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++)
            list.add( new ArrayList<>());
        for(List<Integer>e: edges){
            int from = e.get(0), to = e.get(1);
            list.get(from).add(to);
            list.get(to).add(from);
        }
        return list;
    }
}