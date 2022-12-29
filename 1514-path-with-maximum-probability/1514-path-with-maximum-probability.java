class Node{
    int node;
    double prob;
    Node(int node,double prob){
        this.node = node;
        this.prob = prob;
    }
}
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        // more we multiply it reduces more
        List<List<Node>> list = new ArrayList<>();
        for(int i=0;i< n;i++)
            list.add(new ArrayList<>());
        for(int i =0;i<edges.length;i++){
            int from = edges[i][0], to = edges[i][1];
            double p = succProb[i];
            list.get(from).add(new Node(to, p));
            list.get(to).add(new Node(from ,p));
        }
        // traverse the graph  now
        double[] dp = new double[n];
        Arrays.fill(dp , 0);
        dp[start]  =1 ;
        
        // {currnode, up_to_curr_probability}
        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a,b)->a.prob >b.prob?-1: (a.prob==b.prob?0:1)
        );
        pq.add(new Node(start,1));
        
        while(!pq.isEmpty()){
            Node front = pq.poll();
            int curr_node=  front.node;
            double cp = front.prob;
            for(Node adj: list.get(front.node)){
                int adj_node = adj.node ;
                double np = adj.prob*cp;
                if(np>dp[adj_node]){
                    dp[adj_node] =np;
                    pq.add(new Node(adj_node,np));
                }
            }
        }
        
        return dp[end];
    }
}