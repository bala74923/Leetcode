class Solution {
    public int[] findOrder(int N, int[][] edge) {
        // change edges to graph
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<N;i++)
            list.add( new ArrayList<>());
        int[] in = new int[N];
        for(int[] e: edge){
            int from = e[1] , to = e[0];
            list.get(from).add(to);
            in[to] ++;
        }
        
        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<N;i++){
            if(in[i]==0)
                q.add(i);
        }
        //System.out.println(list);
        int[] res = new int[N];
        int ind = 0;
        while(!q.isEmpty()){
            int front= q.poll();
            res[ind++]= front;
            for(int adj: list.get(front)){
                in[adj]--;
                if(in[adj]==0) q.add(adj);
            }
        }
        if(ind!=N) return new int[0];
        return res;
    }
}