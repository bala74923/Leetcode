class Solution {
    int[] mem;
    public boolean canJump(int[] nums) {
        mem = new int[nums.length];
        Arrays.fill(mem,-1);
        return f(0, nums);
    }
    boolean f(int ind,int[] nums){
        if(ind>=nums.length) return false;
        if(ind==nums.length-1) return true;
        if(mem[ind]!=-1)
            return mem[ind]==1;
        boolean  res = false;
        for(int jump = 1;jump<=nums[ind];jump++){
            if(f(ind+jump, nums)){
                mem[ind] = 1;
                return true;
            }
        }
        mem[ind] = 0;
        return false;
    }
}