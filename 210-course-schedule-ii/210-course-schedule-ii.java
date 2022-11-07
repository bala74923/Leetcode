class Solution {
    public int[] findOrder(int V, int[][] arr) {
        int[] inside = new int[V];
        List<List<Integer>> list= getList(V,arr);
        int[] topo=  new int[V];
        int ind =0;
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int vertex=0;vertex<V;vertex++){
            for(int adj: list.get(vertex)){
                inside[adj]++;
            }
        }
        
        for(int i=0;i<V;i++){
            if(inside[i]==0)
                q.add(i);
        }
            
        while(!q.isEmpty()){
            int front = q.poll();
            topo[ind++] = front;
            // after removing this node ,delete the edges
            for(int adj: list.get(front)){
                inside[adj]--;
                if(inside[adj]==0) q.add(adj);
            }
        }
        //System.out.println(topo);
        if(ind!=V) return new int[0];
        int lo = 0,hi = ind-1;
        while(lo<hi){
            int temp = topo[lo];
            topo[lo] = topo[hi];
            topo[hi] = temp;
            lo++;hi--;
        }
        return topo;
    }
    static List<List<Integer>> getList(int V,int[][] arr){
        List<List<Integer>> list = new ArrayList<>(V);
        for(int i=0;i<V;i++) list.add(new ArrayList<>());
        for(int[] e: arr){
            list.get(e[0]).add(e[1]);
        }
        return list;
    }
}