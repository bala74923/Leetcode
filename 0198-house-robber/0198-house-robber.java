class Solution {
    public int rob(int[] nums) {
        return solve(nums);
    }
    int solve(int[] nums){
         int N = nums.length;
        
        int prepre = nums[0],pre = prepre;
        if(N>1) pre = Math.max(nums[0],nums[1]);
        for(int ind=2;ind<N;ind++){
            int pick  = nums[ind]  + prepre;
            int notPick = pre;
            int curr = Math.max(pick,notPick);
            
            prepre = pre;
            pre= curr;
        }
        return pre;
    }
    
}