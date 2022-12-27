class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int add) {
        PriorityQueue<Integer> pq  = new PriorityQueue<>();
        int full = 0;
        for(int i=0;i<rocks.length ;i++){
            int need= capacity[i] - rocks[i];
            if(need==0) full++;
            else pq.add(need);
        }
        while(!pq.isEmpty()){
            int has = pq.poll();
            if(has>add) break;
            full++;
            add-=has;
        }
        return full;
    }
}