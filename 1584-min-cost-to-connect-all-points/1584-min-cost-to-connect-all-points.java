class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                pq.add(new int[]{dist(points,i,j), i, j});
            }
        }
        int[] dsuf = new int[points.length];
        Arrays.fill(dsuf,-1);
        int mst_sum = 0, count = 0;
        while(!pq.isEmpty()){
            int[] front = pq.poll();
            if(union(front[1],front[2],dsuf)){
                mst_sum+=front[0];
                count++;
                if(count==points.length-1)
                    break;
            }
        }
        return mst_sum;
    }
    boolean union(int a,int b,int[] dsuf){
        int pa = find(a,dsuf), pb = find(b,dsuf);
        if(pa==pb) //edge forms cycle
            return false;
        else{
            dsuf[pa] = pb;
            return true;
        }
    }
    int dist(int[][] a,int i,int j){
        return Math.abs(a[i][0]-a[j][0]) + Math.abs(a[i][1]-a[j][1]);
    }
    int find(int node,int[] dsuf){
        if(dsuf[node]==-1)
            return node;
        return dsuf[node] = find(dsuf[node],dsuf);
    }
}