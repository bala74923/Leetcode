class Solution {
    int[] mem;
    public int rob(int[] nums) {
        int N = nums.length;
        mem = new int[N];
        Arrays.fill(mem,-1);
        return f(N-1,nums);
    }
    int f(int ind,int[] nums){
        if(ind==0) return nums[ind];
        if(ind==1) return Math.max(nums[0],nums[1]);
        if(mem[ind]!=-1)
            return mem[ind];
        int pick  = nums[ind]  + f(ind-2,nums);
        int notPick = f(ind-1,nums);
        return mem[ind] = Math.max(pick,notPick);
    }
}