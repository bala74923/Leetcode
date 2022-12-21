consider there is an edge between every node and edge weight is manhattan distance
apply this on the template of MST
​
Template 1:
​
```
int mst_sum = 0;
​
// min heap based on short distance
PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b)->a[0]-b[0]);
// add the intial source node
pq.add(new int[]{0, src });
while(!pq.isEmpty()){
// polls the node with small distance
int[] front = q.poll();
int node= front[1], dist = front[ 0]
// if node is already processed dont do it again
if(visited[node]) continue;
visited[node] = true;
mst_sum += dist; // adding current node to the mst
for( adj: adjacency list ( node) ){
int newDistance =calculate(adj)
pq.add (new int[]{ newDistance, adj}) ;
}
}
return mst_sum ;
```