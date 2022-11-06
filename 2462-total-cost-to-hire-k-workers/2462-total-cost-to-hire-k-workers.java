class Solution {
    public long totalCost(int[] costs, int k, int c) {
        long ans = 0;
        int N = costs.length;
        Comparator<int[]> comp = (a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0];
        PriorityQueue<int[]> p1 =new PriorityQueue<>(comp), p2 = new PriorityQueue<>(comp);
        int left=0,right = N-1;
        for(;left<=right && left<c;left++,right--){
            p1.add(new int[]{costs[left],left});
            if(left!=right)
                p2.add(new int[]{costs[right],right});
        }
        int i1 = left, i2 = right;
        int max = (int)1e9;
        while(k-->0){
            int[] v1 = p1.isEmpty()?new int[]{max,max}: p1.peek();
            int[] v2 = p2.isEmpty()?new int[]{max,max}: p2.peek();
            if(v1[0]<v2[0] ||(v1[0]==v2[0]&& v1[1]<v2[1])){
                ans+=p1.poll()[0];
                if(i1<=i2) p1.add(new int[]{costs[i1],i1++});
            }else{
                ans+=p2.poll()[0];
                if(i1<=i2) p2.add(new int[]{costs[i2],i2--});
            }
        }
        return ans;
    }
}