class Solution {
    int[][] mem;
    public int maxCoins(int[] nums) {
        int N = nums.length;
        int[] arr = new int[nums.length+2];
        Arrays.fill(arr,1);
        mem = new int[N+2][N+2];
        for(int[] mem1: mem)
            Arrays.fill(mem1,-1);
        for(int i=1;i<=nums.length;i++)
            arr[i] = nums[i-1];
        return f(1,nums.length,arr);
    }
    int f(int left,int right,int[] arr){
        if(left>right) return 0;
        if(mem[left][right]!=-1)
            return mem[left][right];
        int maxi = -(int)1e9;
        for(int ind=left;ind<=right;ind++){
            int calc = arr[ind]*arr[left-1]*arr[right+1];
            maxi  = Math.max(maxi, calc+ f(left,ind-1,arr)+
                            f(ind+1,right,arr));
        }
        return mem[left][right] = maxi;
    }
}